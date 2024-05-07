package com.example.atl_unec2.uicomponents.practical.practical7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.atl_unec2.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var stateAdapter: MyTabFragmentStateAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = listOf("PRODUCTS", "CLIENTS")
        stateAdapter = MyTabFragmentStateAdapter(list, this)
        binding.viewPager.adapter = stateAdapter


        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = list[position]
        }.attach()
    }






}