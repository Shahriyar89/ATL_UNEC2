package com.example.atl_unec2.network

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentRetrofitImplBinding
import com.example.atl_unec2.databinding.FragmentRoomDbBinding
import com.example.atl_unec2.network.multipart.uploadFile
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream

class RetrofitImplFragment : Fragment() {
    private var _binding: FragmentRetrofitImplBinding? = null
    private val binding get() = _binding!!
    private val PICK_IMAGE_REQUEST = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRetrofitImplBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.callApi.setOnClickListener {
//            fetchDataFromApi()
            pickImage()


        }

    }

    private fun fetchDataFromApi() {
        val dogService = RetrofitHelper.getInstance().create(MyServices::class.java)
        val callService = dogService.fetchData()
        callService.enqueue(object : Callback<DogModel> {
            override fun onResponse(call: Call<DogModel>, response: Response<DogModel>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("ResponseData", "$data")
                    binding.dogImage.load(data?.imageUrl)
                } else {
                    // Handle error response
                }
            }

            override fun onFailure(call: Call<DogModel>, t: Throwable) {
                Log.d("ResponseData", "Fail")
            }

        })

    }


    private fun pickImage(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            selectedImageUri?.let {
                val file = File(getRealPathFromURI(it))
                uploadFile(file, "Sample description")
            }
        }
    }


    private fun getRealPathFromURI(uri: Uri): String {
        var filePath = ""
        val cursor = requireActivity().contentResolver.query(uri, null, null, null, null)
        cursor?.moveToFirst()?.let {
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            filePath = cursor.getString(idx)
            cursor.close()
        }
        return filePath
    }
}