package com.tetamatrix.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tetamatrix.besinlerkitabi.R
import com.tetamatrix.besinlerkitabi.helper.util.placeholderYap
import com.tetamatrix.besinlerkitabi.viewModel.BesinDetayFragmentViewModel
import com.tetamatrix.besinlerkitabi.databinding.FragmentBesinDetayBinding
import com.tetamatrix.besinlerkitabi.helper.util.gorselIndir

class BesinDetayFragment : Fragment() {
    //ViewBinding
    private var _binding: FragmentBesinDetayBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private lateinit var viewModel: BesinDetayFragmentViewModel

    //DataBinding
    private lateinit var dataBinding: FragmentBesinDetayBinding

    private var besinId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentBesinDetayBinding.inflate(inflater, container, false)
        val view = binding.root//Normal View
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_besin_detay, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Gelen argüman var ise
        //Argumanları al
        arguments?.let {
            besinId = BesinDetayFragmentArgs.fromBundle(it).besinId
        }

        viewModel = ViewModelProviders.of(this).get(BesinDetayFragmentViewModel::class.java)
        viewModel.roomVerisiniAll(besinId)
        observeLiveData()
    }

    //ViewModelımızdaki tanımlarımızı observe edme yani gözlemleyen(dinleyen)
    //herbir değişkeni gözlemleme
    fun observeLiveData() {
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer { besin ->
            besin?.let {
                /*binding.besinIsimtxt.text = it.isim
                binding.besinKaloritxt.text = it.kalori
                binding.besinKarbonHidrartxt.text = it.karbonhidrad
                binding.besinProteintxt.text = it.protein
                binding.besinYagtxt.text = it.yag
                context?.let {
                    binding.imageView.gorselIndir(besin.gorsel, placeholderYap(it))
                }*/
                dataBinding.secilenBesin=it
            }
        })
    }
}