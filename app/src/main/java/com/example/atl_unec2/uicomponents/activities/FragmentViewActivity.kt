package com.example.atl_unec2.uicomponents.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivityFragmentViewBinding
import com.example.atl_unec2.uicomponents.fragments.FirstFragment
import com.example.atl_unec2.uicomponents.fragments.ProductFragment
import com.example.atl_unec2.uicomponents.dialogs.OthersFragment
import com.example.atl_unec2.uicomponents.practical.practical7.HomeFragment
import com.example.atl_unec2.uicomponents.recyclerview.ViewPagerFragment


class FragmentViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentViewBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)


        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val firstFragment = FirstFragment()
        val productFragment = ProductFragment()
        val otherFragment= OthersFragment()

//        fragmentTransaction.add(R.id.fragment_container_view,firstFragment)
//        fragmentTransaction.replace(R.id.fragment_container_view, productFragment)
//        fragmentTransaction.commit()

        val fragment=ViewPagerFragment()

        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view, HomeFragment())
//                addToBackStack(null)
                commit()

            }
        }


        button2.setOnClickListener {

            val bundle = Bundle()
            bundle.also {
                it.putBoolean("IsActive", true)
                it.putAll(bundle)
                it.putAll(bundleOf("NameUser" to "AHMAD"))

            }

            productFragment.arguments = bundle

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view, productFragment)
//                addToBackStack(null)
                commit()
            }
        }

    }

}