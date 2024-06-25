package com.example.atl_unec2.coroutines

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.atl_unec2.coroutines.network.MoviesViewModel
import com.example.atl_unec2.coroutines.network.Resource
import com.example.atl_unec2.databinding.FragmentCoroutinesBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


/**

 * Dispatchers.Default:
 *
 * Description: Optimized for CPU-intensive work such as sorting large lists or performing complex calculations.
 * Thread Pool: Uses a shared pool of background threads (usually the same number as the number of CPU cores).
 * Use Case: Suitable for tasks that require significant CPU resources and are not IO-bound. Examples include computations, data processing, and algorithms.


 * Dispatchers.IO:
 *
 * Description: Optimized for offloading IO tasks to a shared pool of threads. These tasks include network requests, file operations, and database interactions.
 * Thread Pool: Uses a larger pool of threads compared to Default to handle potentially blocking IO operations.
 * Use Case: Suitable for IO-bound tasks that may block the thread, such as reading from disk or making network requests.


 * Dispatchers.Main:
 *
 * Description: Confined to the main thread, designed for tasks that interact with the UI and need to update it.
 * Thread Pool: Uses the main thread.
 * Use Case: Suitable for tasks that need to update the UI, such as rendering views, handling user input, and other UI-related actions. Only available on platforms with a main thread, like Android.


 * Dispatchers.Unconfined:
 *
 * Description: Starts the coroutine in the caller thread but only until the first suspension point. After suspension, it resumes the coroutine in the thread that is determined by the suspending function used.
 * Thread Pool: Does not confine the coroutine to any specific thread after suspension.
 * Use Case: Suitable for coroutines that do not care about the thread they are running on after suspension. Rarely used, and should be used with caution as it can lead to unpredictable behavior and potential concurrency issues.
 *
 */


class CoroutinesFragment: Fragment() {



    private var _binding: FragmentCoroutinesBinding? = null
    private val binding get() = _binding!!

//    val job = CoroutineScope(Dispatchers.Main) + Job()

    val viewModel: MoviesViewModel by viewModels()




//    @Inject
//    lateinit var alert:AlertSystem


    private val MY_TAG = "MyTag"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoroutinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        viewModel.getPopularMovies()
        viewModel.getPlayMovies()
        viewModel.getPlayMoviesFlow()


        lifecycleScope.launch {
            viewModel.moviesDataFlow
                .collect{
                when(it){
                    is Resource.Loading->{
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Error->{}
                    is Resource.Success->{
                        Toast.makeText(requireContext(), "Ugurlu", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }




        lifecycleScope.launch {
            viewModel.moviesFlowData.collect {
                when (it) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), "Ugurlu", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), "Xeta bas verdi", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }


//
//        val repository=MovieRepository()
//       CoroutineScope(Dispatchers.IO).launch {
//           repository.getPlayNowMovies()
//       }
//        workWithJob()


//        Coroutines scope
//        Log.d(MY_TAG, "${Thread.currentThread().name}")
//        Log.d(MY_TAG, "Hello without coroutine")

//        GlobalScope.launch(Dispatchers.Default) {
////            delay(3000L)
//            Log.d(MY_TAG, "${Thread.currentThread().name}")
//
//            withContext(Dispatchers.IO) {
//                showToast()
//            }
//        }


//suspend function
//        GlobalScope.launch {
//            Log.d(MY_TAG,doSomething())
//            Log.d(MY_TAG,doSomething2())
//        }


//        runBlocking
//        runBlocking (Dispatchers.Main){
////            binding.exampleText.text="Hello students"
//        }


//
//        GlobalScope.launch(Dispatchers.Unconfined) {
//            Log.d(MY_TAG, "${Thread.currentThread().name}")
//            delay(1000)
//            Log.d(MY_TAG, "${Thread.currentThread().name}")
//        }

    }


    fun showToast() {
        Toast.makeText(requireContext(), "${Thread.currentThread().name}", Toast.LENGTH_SHORT)
            .show()
    }


    private suspend fun doSomething(): String {
        delay(3000)
        return "Return first function "
    }

    private suspend fun doSomething2(): String {
        delay(3000)
        return "Return second function "
    }


//    private fun workWithJob() {
//        var index = 0
//        job.launch {
//            for (i in 0..100) {
//                delay(1000)
//                index++
//                Log.d(MY_TAG, "$index")
//                if (index == 3) {
//                    job.cancel()
//                }
//            }
//
//
//        }
//    }


}