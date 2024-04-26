package com.example.atl_unec2.activityandfragment.practical.practical7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atl_unec2.activityandfragment.recyclerview.ProductInfo
import com.example.atl_unec2.databinding.FragmentMyProductsBinding

class ProductsFragment : Fragment() {
    private var _binding: FragmentMyProductsBinding? = null
    private val binding get() = _binding!!
    lateinit var productAdapter: ProductsRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productList = arrayListOf(
            Product(
                title = "MAC",
                price = "3000$",
                logoUrl = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png",
                isActive = true,
                description = ""
            ),
            Product(
                title = "HP",
                price = "2000$",
                logoUrl = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png",
                isActive = true,
                description = ""
            ),
            Product(
                title = "Lenovo",
                price = "3000$",
                logoUrl = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png",
                isActive = true,
                description = ""
            ),
            Product(
                title = "Sony",
                price = "3100$",
                logoUrl = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png",
                isActive = true,
                description = ""
            ),

            )

        productAdapter = ProductsRecyclerViewAdapter()
        productAdapter.setProductList(productList)
        binding.myProducts.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.myProducts.adapter = productAdapter
    }


}