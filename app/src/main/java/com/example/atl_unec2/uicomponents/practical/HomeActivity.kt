package com.example.atl_unec2.uicomponents.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.atl_unec2.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
        }

    }
}