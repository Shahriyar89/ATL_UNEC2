package com.example.atl_unec2.uicomponents.recyclerview

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.atl_unec2.uicomponents.fragments.FirstFragment
import com.example.atl_unec2.uicomponents.fragments.ProductFragment

class ProductStatePagerAdapter(val list: List<String>, fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProductFragment()
            1 -> FirstFragment()
            2 -> ProductFragment()
            else -> Fragment()
        }
    }

}