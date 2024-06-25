package com.example.atl_unec2.uicomponents.viewmodels

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.atl_unec2.databinding.ActivitySampleBinding
import com.example.atl_unec2.uicomponents.viewmodels.viewmodel.SampleViewModel
import com.example.atl_unec2.uicomponents.viewmodels.viewmodel.SecondViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampleActivity : AppCompatActivity() {

    private  val  viewModel: SampleViewModel by viewModels()
    private lateinit var secondViewModel:SecondViewModel
    private lateinit var binding: ActivitySampleBinding

    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //with dependency
//           viewModel= ViewModelProvider(this,viewModelFactory)[SampleViewModel::class.java]

//        viewModel = ViewModelProvider(this)[SampleViewModel::class.java]


        binding.count.text=viewModel.getQuery()

        binding.count.setOnClickListener {
            val count=viewModel.countNumber()
            binding.countText.text = count
        }

        //Live data observer
        viewModel.observeData?.observe(this) { observeData->
            Toast.makeText(this, observeData as String, Toast.LENGTH_SHORT).show()

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.setQuery("UNEC")
    }
}