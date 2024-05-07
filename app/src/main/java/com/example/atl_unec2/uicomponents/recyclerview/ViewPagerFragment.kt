package com.example.atl_unec2.uicomponents.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.atl_unec2.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment(): Fragment(){


    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list= listOf("PRODUCT", "BRANCHES","DEPARTMENTS")
        val stateAdapter = ProductStatePagerAdapter(list, this)
        binding.pager.adapter = stateAdapter


        TabLayoutMediator(binding.viewTab, binding.pager) { tab, position ->
            tab.text = list[position]
        }.attach()

    }


}