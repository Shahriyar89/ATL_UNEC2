package com.example.atl_unec2.network.multipart

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

fun createMultipartBodyPart(file: File, description: String): Pair<MultipartBody.Part, RequestBody> {
    val requestFile = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
    val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)
    val descriptionPart = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), description)
    return Pair(filePart, descriptionPart)
}
