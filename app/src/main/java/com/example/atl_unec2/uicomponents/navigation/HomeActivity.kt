package com.example.atl_unec2.uicomponents.navigation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivityHome2Binding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHome2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHome2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.my_nav_graph)
        navController.setGraph(navGraph, intent.extras)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.othersFragment,
                R.id.productFragment,
                R.id.settingFragment
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeMenu -> navController.navigate(R.id.homeFragment)
                R.id.searchMenu -> navController.navigate(R.id.othersFragment)
                R.id.priceProduct -> navController.navigate(R.id.productFragment)
                R.id.settingMenu -> navController.navigate(R.id.settingFragment)
            }
            true
        }

        intent?.data?.let { deepLinkUri ->
            handleDeepLink(deepLinkUri)
        }
    }


     fun handleDeepLink(deepLinkUri: Uri) {
        // Navigate to the destination associated with the deep link
        val navController = Navigation.findNavController(this, R.id.container)
        navController.navigate(deepLinkUri)

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController.handleDeepLink(intent)
    }

}