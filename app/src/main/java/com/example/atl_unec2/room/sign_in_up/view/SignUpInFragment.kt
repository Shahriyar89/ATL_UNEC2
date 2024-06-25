package com.example.atl_unec2.room.sign_in_up.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.atl_unec2.databinding.FragmentSignUpInBinding
import com.example.atl_unec2.room.sign_in_up.model.Person
import com.example.atl_unec2.room.sign_in_up.viewmodel.SignUpInViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 *
 * Kotlin's SharedFlow and StateFlow are powerful tools for reactive programming, providing different capabilities for managing state and data streams. Understanding when to use each is key to designing an effective and responsive application. Here's an overview of both and some guidance on when to use each.
 *
 * StateFlow
 * StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors. It is designed for scenarios where you have a single up-to-date value that you want to share with multiple consumers, such as UI state.
 *
 * Characteristics
 * Always has a current value.
 * Emits the current value to new subscribers immediately.
 * Ideal for managing UI state in a ViewModel.
 * Common Use Cases
 * Representing UI state in a ViewModel.
 * Propagating state changes in a reactive manner.
 * Replacing LiveData for Kotlin-only projects.
 *
 *
 *
 * SharedFlow
 * SharedFlow is a highly configurable, shared hot flow that allows for multiple emitters and collectors, making it suitable for broadcasting events to multiple subscribers.
 *
 * Characteristics
 * Does not have a default value.
 * Can be replayed, meaning new subscribers can receive a specified number of previous emissions.
 * Suitable for event streams like navigation events, one-time messages, and broadcasts.
 * Common Use Cases
 * Event buses or message buses.
 * One-time UI events like navigation or showing a toast/snackbar.
 * Broadcasting events to multiple consumers.
 *
 *
 *
 * When to Use StateFlow
 * Single Source of Truth: When you need to represent a single state that can change over time and should be shared with multiple subscribers, such as a UI state in a ViewModel.
 * Immediate Emission to New Subscribers: When you want new subscribers to immediately receive the latest value upon subscription.
 * When to Use SharedFlow
 * Event Handling: When you need to handle events that may not be ongoing states, such as navigation commands, showing messages, or other one-time actions.
 * Broadcasting to Multiple Consumers: When you need to broadcast data to multiple consumers without maintaining a single state, such as event buses or notifications.
 * Practical Example
 * Suppose you have a ViewModel that manages both UI state and navigation events. You can use StateFlow for the UI state and SharedFlow for navigation events.
 *
 */


class SignUpInFragment : Fragment() {


    private var _binding: FragmentSignUpInBinding? = null
    private val binding get() = _binding!!

    val viewModel: SignUpInViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpInBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = binding.userName.text.toString()
        val password = binding.password.text.toString()


        binding.signIn.setOnClickListener {
            viewModel.isPersonAvailable(name, password)
            resetInputs()
        }
        binding.signUp.setOnClickListener {
            viewModel.registerUser(Person(name = name, password = password))
            resetInputs()
        }

        lifecycleScope.launch {
            viewModel.allPersons?.collect{

            }
        }
        observeLocalDbResponse()


//        Button on click call viewmodel method
        
//        observe flow data


    }

    private fun observeLocalDbResponse() {
        viewModel.isPersonAvailable.observe(this) {
            if (it) Toast.makeText(requireContext(), "Ugurlu giris", Toast.LENGTH_SHORT).show()
        }

        runBlocking {
            viewModel.allPersons?.collect {
                Log.d("MYTAG", "${it.size}")
            }
        }
    }


    private fun resetInputs() {
        binding.userName.setText("")
        binding.password.setText("")
    }

}