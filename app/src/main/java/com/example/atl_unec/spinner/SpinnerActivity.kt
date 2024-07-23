package com.example.atl_unec.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {

    lateinit var binding: ActivitySpinnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        setDefaultSpinner()

        setCustomSpinner()
    }


    private fun setDefaultSpinner() {
        val spinner = binding.spinner
        ArrayAdapter.createFromResource(this, R.array.dropdown_items, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        // Set up an item selected listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                // An item was selected. You can retrieve the selected item using
                val selectedItem = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@SpinnerActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }



    private fun setCustomSpinner(){
     val  spinner= binding.customSpinner

        // Create a list of items for the spinner
        val items = listOf(
            Item(R.drawable.baseline_home_24, "Item 1"),
            Item(R.drawable.baseline_search_24, "Item 2"),
            Item(R.drawable.ic_launcher_foreground, "Item 3"),
            Item(R.drawable.baseline_attach_money_24, "Item 4")
        )

        // Create an instance of the custom adapter
        val adapter = CustomSpinnerAdapter(this, items)

        // Apply the adapter to the spinner
        spinner.adapter = adapter


        // Set up an item selected listener
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val selectedItem = items[position].text
                Toast.makeText(this@SpinnerActivity, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }
}