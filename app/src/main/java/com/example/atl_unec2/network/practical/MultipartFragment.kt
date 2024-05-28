package com.example.atl_unec2.network.practical

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.atl_unec2.R
import com.example.atl_unec2.databinding.FragmentMultipartBinding
import com.example.atl_unec2.databinding.FragmentRetrofitImplBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


class MultipartFragment : Fragment() {
    private var _binding: FragmentMultipartBinding? = null
    private val binding get() = _binding!!

    private val PICK_IMAGE_REQUEST = 1
    private val CLIENT_ID = "b6a8f40a0be58c6"

    private val imgurApiService by lazy {
        RetrofitClient.instance.create(ImgurApiService::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMultipartBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.uploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val selectedImageUri: Uri = data.data!!
            val filePath = getPathFromUri(selectedImageUri)
            if (filePath != null) {
                uploadImage(File(filePath))
            } else {
                Toast.makeText(requireContext(), "Unable to get the file path", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun getPathFromUri(uri: Uri): String? {
        var filePath: String? = null
        val cursor = requireActivity().contentResolver.query(uri, null, null, null, null)
        if (cursor != null) {
            cursor.moveToFirst()
            val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            filePath = cursor.getString(index)
            cursor.close()
        }
        return filePath
    }

    private fun uploadImage(file: File) {
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
        val title = RequestBody.create("text/plain".toMediaTypeOrNull(), "Test Image")

        imgurApiService.uploadImage("Client-ID $CLIENT_ID", body, title)
            .enqueue(object : Callback<UploadResponse> {
                override fun onResponse(
                    call: Call<UploadResponse>,
                    response: Response<UploadResponse>
                ) {
                    if (response.isSuccessful) {
                        val uploadResponse = response.body()
                        Toast.makeText(
                            requireContext(),
                            "Image Uploaded: ${uploadResponse?.data?.link}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Upload failed: ${response.message()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                    Toast.makeText(
                        requireContext(),
                        "Upload failed: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
}