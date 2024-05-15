package com.example.atl_unec2.uicomponents.viewmodels.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentExample2Binding
import com.example.atl_unec2.databinding.FragmentSampleBinding

class SampleFragment : Fragment() {

    private var _binding: FragmentSampleBinding? = null
    private val binding get() = _binding!!

    val viewModel: SampleViewModel by viewModels(ownerProducer = { requireParentFragment() })


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSampleBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.counterTV.setOnClickListener {
          binding.counterTV.text=viewModel.countNumber()
       }
    }

}