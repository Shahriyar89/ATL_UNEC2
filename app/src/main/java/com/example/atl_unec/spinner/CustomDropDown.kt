package com.example.atl_unec.spinner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import com.example.atl_unec2.R

class CustomDropDown(private val context: Context, private val attr: AttributeSet) :
    LinearLayout(context, attr) {


    lateinit var spinner: Spinner

    lateinit var title: TextView


    init {

        val view = inflate(context, R.layout.my_drop_down, this)
        spinner = view.findViewById(R.id.spinner)
        title = view.findViewById(R.id.textTitle)

        setDefaultSpinner()
    }


    private fun setDefaultSpinner() {
        ArrayAdapter.createFromResource(
            context,
            R.array.dropdown_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
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
                val selectedItem = parent.getItemAtPosition(position).toString()
                title.text = selectedItem

                // An item was selected. You can retrieve the selected item using
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
    }


}

fun main() {
    val string: Any = "1"
    try {
        val resultValue = string as Int
        println(resultValue)
    } catch (e: ClassCastException) {
        println("Caused exception $e")
    }
}