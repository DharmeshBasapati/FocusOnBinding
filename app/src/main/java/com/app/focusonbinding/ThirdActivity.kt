package com.app.focusonbinding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.focusonbinding.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityThirdBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, MyTestFragment(), "TAG")
            .commit()

        setContentView(binding.root)
    }
}