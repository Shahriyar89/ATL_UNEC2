package com.example.atl_unec.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.atl_unec2.R

class CustomSpinnerAdapter(private val context: Context, private val items: List<Item>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_spinner_item, parent, false)

        val itemIcon: ImageView = view.findViewById(R.id.item_icon)
        val itemText: TextView = view.findViewById(R.id.item_text)

        val item = items[position]
        itemIcon.setImageResource(item.icon)
        itemText.text = item.text

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getView(position, convertView, parent)
    }
}


