package com.example.atl_unec2.activityandfragment.practical.practical7

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyTabFragmentStateAdapter(val fragmentList: List<String>, fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProductsFragment()
            else -> ClientsFragment()
        }
    }

}