package com.example.atl_unec2.uicomponents.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atl_unec2.R
import com.squareup.picasso.Picasso

class ProductRecyclerViewAdapter :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {

    var onClickLambda :((ProductInfo)->Unit)?=null
    var onClickElement1:OnClickElement? = null
    private var productList = arrayListOf<ProductInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.product_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productList[position]
        holder.nameView.text = item.name
        holder.priceView.text = item.price
        Picasso.get().load(item.image).into(holder.logoView)

        holder.itemView.setOnClickListener {
            onClickElement1?.onClickItem(item)
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameView = view.findViewById<TextView>(R.id.title)
        val priceView = view.findViewById<TextView>(R.id.price)
        val logoView = view.findViewById<ImageView>(R.id.image)

    }

    fun setOnClickElement(onClickelement:OnClickElement){
        this.onClickElement1=onClickelement
    }

    fun setProductList(productList: ArrayList<ProductInfo>){
        this.productList.clear()
        this.productList=productList
        notifyDataSetChanged()
    }


}

