package com.tetamatrix.besinlerkitabi.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tetamatrix.besinlerkitabi.Helper.Adapter.RecyclerAdapterBesinListesi
import com.tetamatrix.besinlerkitabi.ViewModel.BesinListesiFragmentViewModel
import com.tetamatrix.besinlerkitabi.databinding.FragmentBesinListesiBinding

class BesinListesiFragment : Fragment() {
    //ViewBinding
    private var _binding: FragmentBesinListesiBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private lateinit var viewModel: BesinListesiFragmentViewModel

    //
    private val recyclerBesinAdapter = RecyclerAdapterBesinListesi(ArrayList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBesinListesiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BesinListesiFragmentViewModel::class.java)
        viewModel.refleshdata()

        binding.rcyclerBesinListesi.layoutManager = LinearLayoutManager(context)
        binding.rcyclerBesinListesi.adapter = recyclerBesinAdapter

        binding.swipeRefleshLayout.setOnRefreshListener {
            binding.prgbBesinListesi.visibility = View.VISIBLE
            binding.txwBesinlerListesi.visibility = View.GONE
            binding.rcyclerBesinListesi.visibility = View.GONE
            viewModel.refleshFromInternet()
            binding.swipeRefleshLayout.isRefreshing = false
        }
        observeLiveData()

    }

    //ViewModelımızdaki tanımlarımızı observe edme yani gözlemleyen(dinleyen)
    //herbir değişkeni gözlemleme
    fun observeLiveData() {
        //Listenin observesi
        viewModel.besinler.observe(viewLifecycleOwner, Observer { besinler ->
            besinler?.let {
                binding.rcyclerBesinListesi.visibility = View.VISIBLE
                recyclerBesinAdapter.besinlistesiGuncelle(besinler)
            }
        })
        //Hatanın observesi
        viewModel.besinHataMesajı.observe(viewLifecycleOwner, Observer { hata ->
            hata?.let {
                if (it) {
                    binding.txwBesinlerListesi.visibility = View.VISIBLE
                    binding.rcyclerBesinListesi.visibility = View.GONE
                } else {
                    binding.txwBesinlerListesi.visibility = View.GONE
                }
            }
        })

        //Yukleniyor progresin observesi
        viewModel.besinHataMesajı.observe(viewLifecycleOwner, Observer { yukleniyor ->
            yukleniyor?.let {
                if (it) {
                    binding.rcyclerBesinListesi.visibility = View.GONE
                    binding.txwBesinlerListesi.visibility = View.GONE
                    binding.prgbBesinListesi.visibility = View.VISIBLE
                } else {
                    binding.prgbBesinListesi.visibility = View.GONE
                }
            }
        })
    }
}