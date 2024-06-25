package com.example.atl_unec2.di

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.atl_unec2.R
import com.example.atl_unec2.di.TestMoviesViewmodel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TestHiltFragment : Fragment() {


    val viewModel :TestMoviesViewmodel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_hilt, container, false)
    }

}