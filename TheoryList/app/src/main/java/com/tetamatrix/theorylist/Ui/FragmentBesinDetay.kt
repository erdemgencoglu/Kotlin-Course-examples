package com.tetamatrix.theorylist.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tetamatrix.theorylist.R
import com.tetamatrix.theorylist.databinding.FragmentBesinDetayBinding
import com.tetamatrix.theorylist.databinding.FragmentBesinlerBinding

class FragmentBesinDetay : Fragment() {
    private var _binding: FragmentBesinDetayBinding? = null
    private val binding get() = _binding!!

    private var besinId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentBesinDetayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}