package com.example.atl_unec2.uicomponents.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivityHome2Binding
import com.example.atl_unec2.databinding.ActivityProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController =
            (supportFragmentManager.findFragmentById(R.id.productContainer) as NavHostFragment).navController
        navController.handleDeepLink(intent)

        val navGraph = navController.navInflater.inflate(R.navigation.product_nav_graph)
        navController.setGraph(navGraph, intent.extras)

        navController.handleDeepLink(intent)
    }
}