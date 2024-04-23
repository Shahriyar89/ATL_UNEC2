package com.example.atl_unec2.activityandfragment.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentCustomDialogBinding
import com.example.atl_unec2.databinding.FragmentOthersBinding

class CustomDialogFragment : DialogFragment() {

    companion object {
        var onClickButton: ((message : String) -> Unit)? = null
    }

    private var _binding: FragmentCustomDialogBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.okay.setOnClickListener {

            onClickButton?.invoke("Button click olundu")
            dialog?.dismiss()
        }



        dialog!!.window!!.setLayout(
            LayoutParams.MATCH_PARENT,
         500
        )

    }


    fun DialogFragment.setFullScreen() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("UNEC_ATL","onCreateDialog")
        return super.onCreateDialog(savedInstanceState)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}