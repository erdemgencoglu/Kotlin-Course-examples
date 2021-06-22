package com.tetamatrix.theorylist.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tetamatrix.theorylist.R
import com.tetamatrix.theorylist.databinding.FragmentBesinlerBinding
import com.tetamatrix.theorylist.databinding.FragmentBesinlerBindingImpl

class FragmentBesinler : Fragment() {
    private var _binding: FragmentBesinlerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBesinlerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}