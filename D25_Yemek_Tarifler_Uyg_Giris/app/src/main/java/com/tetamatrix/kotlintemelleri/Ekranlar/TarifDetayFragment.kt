package com.tetamatrix.kotlintemelleri.Ekranlar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tetamatrix.kotlintemelleri.R
import com.tetamatrix.kotlintemelleri.databinding.FragmentTarifDetayBinding


class TarifDetayFragment : Fragment() {

    private var _binding: FragmentTarifDetayBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
        _binding = FragmentTarifDetayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}