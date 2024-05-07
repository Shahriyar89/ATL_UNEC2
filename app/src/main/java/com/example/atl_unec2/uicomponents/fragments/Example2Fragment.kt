package com.example.atl_unec2.uicomponents.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentExample2Binding
import com.example.atl_unec2.uicomponents.navigation.HomeActivity

class Example2Fragment:Fragment(R.layout.fragment_example2) {

    private var _binding: FragmentExample2Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExample2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.openFragment.setOnClickListener{
           val b= bundleOf("MyAge" to 25)
            b.putString("MYNAME", "AHMAD")
//           findNavController().navigate(Uri.parse("atl://productsFragment/"))
            val uri=Uri.parse("atl://startDestination/")
          findNavController().navigate(uri)
        }




    }
}