package com.app.focusonbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.focusonbinding.databinding.ActivityAnotherBinding

class AnotherActivityUsingDataBinding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityAnotherBinding = DataBindingUtil.inflate(layoutInflater,R.layout.activity_another,null,false)

        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.myViewModel = viewModel

        binding.lifecycleOwner = this

        setContentView(binding.root)
    }
}