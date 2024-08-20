package com.ar.catpaging

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ar.catpaging.databinding.ActivityMainBinding
import com.ar.catpaging.presentation.screens.combine.CombineSourceActivity
import com.ar.catpaging.presentation.screens.local.LocalSourceActivity
import com.ar.catpaging.presentation.screens.remote.RemoteSourceActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.let {
            it.btnDatabase.setOnClickListener {
                startActivity(Intent(this, LocalSourceActivity::class.java))
            }
            it.btnNetworkAndDatabase.setOnClickListener {
                startActivity(Intent(this, CombineSourceActivity::class.java))
            }
            it.btnNetworkPage.setOnClickListener {
                startActivity(Intent(this, RemoteSourceActivity::class.java))
            }
        }
    }
}