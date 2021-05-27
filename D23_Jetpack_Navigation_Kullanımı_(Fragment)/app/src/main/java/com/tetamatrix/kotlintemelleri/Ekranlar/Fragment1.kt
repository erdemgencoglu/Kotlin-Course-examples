package com.tetamatrix.kotlintemelleri.Ekranlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tetamatrix.kotlintemelleri.R
import com.tetamatrix.kotlintemelleri.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    //viewbinding
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        _binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view //Next butonu tıklama

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener {
            //Navigation için action tanımlama
            val action = Fragment1Directions.actionFragment1ToFragment2("Erdem Gençoğlu")
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}