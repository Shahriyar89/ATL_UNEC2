package com.example.atl_unec2.uicomponents.practical.practical7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atl_unec2.R
import com.squareup.picasso.Picasso

class ProductsRecyclerViewAdapter :
    RecyclerView.Adapter<ProductsRecyclerViewAdapter.ProductViewHolder>() {

    private var productList = arrayListOf<Product>()


    fun setProductList(arrayList: ArrayList<Product>) {
        this.productList.clear()
        this.productList = arrayList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.title.text = product.title
        holder.subtitle.text = product.description
        holder.price.text = product.price
        holder.isActive.isChecked = product.isActive
        Picasso.get().load(product.logoUrl).into(holder.image)

    }


    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.productTitle)
        val image = view.findViewById<ImageView>(R.id.logoProduct)
        val subtitle = view.findViewById<TextView>(R.id.productDescription)
        val isActive = view.findViewById<CheckBox>(R.id.isActive)
        val price = view.findViewById<TextView>(R.id.priceProduct)

    }

}