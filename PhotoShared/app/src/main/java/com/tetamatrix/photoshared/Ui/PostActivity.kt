package com.tetamatrix.photoshared.Ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tetamatrix.photoshared.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}