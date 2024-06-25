package com.example.atl_unec2.coroutines

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentCoroutinesBinding
import com.example.atl_unec2.databinding.FragmentKotlinFlowsBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class KotlinFlowsFragment : Fragment() {

    private var _binding: FragmentKotlinFlowsBinding? = null
    private val binding get() = _binding!!


    val viewmodel: KotlionFlowsViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKotlinFlowsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonActions()


        viewmodel.liveData.observe(this) {
            binding.liveDataTextView.text = it
        }


        lifecycleScope.launch {
            viewmodel.stateFlow.collect {
//                binding.stateFlowTextView.text = it
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }


        lifecycleScope.launch {
            viewmodel.triggerFlow().collect {
                binding.flowTextView.text = it
            }
        }


        lifecycleScope.launch {
            viewmodel.sharedFlow.collect {
                binding.sharedFlowTextView.text = it
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun buttonActions() {
        binding.liveDataBtn.setOnClickListener {
            viewmodel.triggerLiveData()
        }

        binding.stateFlowBtn.setOnClickListener {
            viewmodel.triggerStateFlow()
        }


        binding.sharedFlowBtn.setOnClickListener {
            viewmodel.triggerSharedFlow()
        }


    }


}