package com.app.focusonbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.focusonbinding.databinding.ActivityMainBinding

class MainActivityUsingViewBinding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        binding.tvScreenName.text = "Screen 1"
        binding.btnGoToNext.text = "Go to Playing XI Screen"

        binding.btnGoToNext.setOnClickListener {
            startActivity(Intent(this,ThirdActivity::class.java))
        }

        setContentView(binding.root)
    }
}