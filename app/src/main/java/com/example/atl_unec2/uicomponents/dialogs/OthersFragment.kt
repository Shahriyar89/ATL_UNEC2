package com.example.atl_unec2.uicomponents.dialogs

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentOthersBinding
import kotlin.system.exitProcess

class OthersFragment : Fragment() {
    private var _binding: FragmentOthersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOthersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.exitButton.setOnClickListener {
            showAlertDialog()
        }
        binding.showDialog.setOnClickListener {
            showCustomDialog()
        }

        binding.showBottomDialog.setOnClickListener {
            showBottomSheetFragment()
        }
    }


    private fun showAlertDialog() {

        /*
     ilkin deyerler
         */
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Exit")
        alertDialog.setMessage("Are you sure exit?")
        alertDialog.setCancelable(false)
        alertDialog.setIcon(R.drawable.ic_launcher_foreground)
        //position
        alertDialog.setPositiveButton("Yes") { dialog, a ->
//            dialog.dismiss()
//            dialog.cancel()
            exitProcess(0)

        }

        //negative
        alertDialog.setNegativeButton("No") { dialog, a ->
            dialog.dismiss()
        }

        /*
        end  deyerler
         */
//
        alertDialog.create()

        //gorunmesi
        alertDialog.show()
    }


    private fun showCustomDialog() {
        val dialogFragment = CustomDialogFragment()
        dialogFragment.isCancelable=false
        
        CustomDialogFragment.onClickButton={m->
            Toast.makeText(requireContext(), m, Toast.LENGTH_SHORT).show()
        }
        dialogFragment.show(childFragmentManager, CustomDialogFragment::class.java.name)

    }


    private fun showBottomSheetFragment(){
        val dialog=CustomBottomSheetFragment()

        dialog.show(childFragmentManager,"BottomSheet")
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}