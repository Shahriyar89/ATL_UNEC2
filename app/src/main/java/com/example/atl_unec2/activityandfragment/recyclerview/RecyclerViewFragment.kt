package com.example.atl_unec2.activityandfragment.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentOthersBinding
import com.example.atl_unec2.databinding.FragmentRecyclerPagerViewBinding

class RecyclerViewFragment : Fragment() {
    private var _binding: FragmentRecyclerPagerViewBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: ProductRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerPagerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productList = arrayListOf(
            ProductInfo(
                name = "MAC",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "HP",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Lenovo",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Sony",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "MAC",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "HP",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Lenovo",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Sony",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "MAC",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "HP",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Lenovo",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Sony",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "MAC",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "HP",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Lenovo",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Sony",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "MAC",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "HP",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Lenovo",
                price = "3000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            ),
            ProductInfo(
                name = "Sony",
                price = "2000$",
                image = "https://e7.pngegg.com/pngimages/695/1018/png-clipart-desktop-computer-computer-graphics-computer-monitor-computer-purple-computer-network-thumbnail.png"
            )
        )


        adapter = ProductRecyclerViewAdapter()
        adapter.setProductList(productList)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.adapter = adapter
        adapter.onClickLambda = { product ->
            Toast.makeText(requireContext(), "${product.name}", Toast.LENGTH_SHORT).show()
        }


        adapter.setOnClickElement(object : OnClickElement {
            override fun <T> onClickItem(element: T) {
                Toast.makeText(
                    requireContext(),
                    "${(element as ProductInfo).name}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

//    override fun <T> onClickItem(element: T) {
//        Toast.makeText(requireContext(), "${(element as ProductInfo).name}", Toast.LENGTH_SHORT).show()
//    }


}