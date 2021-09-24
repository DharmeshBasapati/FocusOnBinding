package com.app.focusonbinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.focusonbinding.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val playerDetail = intent.extras?.get("PASSED_PLAYER") as Users

        binding.ivUserType.setImageResource(playerDetail.userTypeIcon)
        binding.tvUsername.text = playerDetail.userName
        binding.tvUserType.text = playerDetail.userType

        binding.btnBackToList.setOnClickListener {
            supportFinishAfterTransition()
        }

    }
}