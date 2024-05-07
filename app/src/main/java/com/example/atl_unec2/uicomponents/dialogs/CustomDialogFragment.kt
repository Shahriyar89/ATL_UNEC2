package com.example.atl_unec2.uicomponents.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView.LayoutParams
import com.example.atl_unec2.databinding.FragmentCustomDialogBinding

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
        
        val name=arguments?.getString("MYNAME")

        Toast.makeText(requireContext(), "$name", Toast.LENGTH_SHORT).show()
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