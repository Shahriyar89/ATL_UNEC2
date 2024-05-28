package com.example.atl_unec2.room.sign_in_up.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.atl_unec2.databinding.FragmentSignUpInBinding
import com.example.atl_unec2.room.sign_in_up.model.Person
import com.example.atl_unec2.room.sign_in_up.viewmodel.SignUpInViewModel

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

        observeLocalDbResponse()

    }

    private fun observeLocalDbResponse() {
        viewModel.isPersonAvailable.observe(this) {
            if (it) Toast.makeText(requireContext(), "Ugurlu giris", Toast.LENGTH_SHORT).show()
        }
    }


    private fun resetInputs(){
        binding.userName.setText("")
        binding.password.setText("")
    }

}