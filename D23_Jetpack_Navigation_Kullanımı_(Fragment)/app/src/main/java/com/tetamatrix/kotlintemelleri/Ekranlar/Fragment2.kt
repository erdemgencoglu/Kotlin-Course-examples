package com.tetamatrix.kotlintemelleri.Ekranlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tetamatrix.kotlintemelleri.R
import com.tetamatrix.kotlintemelleri.databinding.Fragment1Binding
import com.tetamatrix.kotlintemelleri.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        _binding = Fragment2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //gelen arguman varmı varsa kullann
        arguments?.let {
            val kulAdi=Fragment2Args.fromBundle(it).username //tanımlamış olduğumuz arguman
            binding.textView.text=kulAdi
        }
        //Navigation için action tanımlama
        binding.buttonPrev.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment1()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}