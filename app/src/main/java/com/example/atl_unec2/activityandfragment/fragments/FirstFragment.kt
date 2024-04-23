package com.example.atl_unec2.activityandfragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.atl_unec2.R
import com.example.atl_unec2.activityandfragment.activities.FragmentViewActivity

class FirstFragment : Fragment() {

    companion object {
        const val MY_TAG = "MyTag"
    }

    lateinit var btn: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(MY_TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(MY_TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        btn = view.findViewById(R.id.btnNext)
        Log.d(MY_TAG, "onCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState !=null){
            val counter=savedInstanceState.get("Counter")
        }

        btn.setOnClickListener {
            val prFragment= ProductFragment()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container_view, prFragment)
//                addToBackStack(null)
                commit()
            }


        }




        Log.d(MY_TAG, "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(MY_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(MY_TAG, "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d(MY_TAG, "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(MY_TAG, "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("Counter",2)

        Log.d(MY_TAG, "onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(MY_TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MY_TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(MY_TAG, "onDetach")

    }


}