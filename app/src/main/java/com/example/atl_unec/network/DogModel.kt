package com.example.atl_unec.network

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("message")
    val imageUrl: String?=null,
    @SerializedName("status")
    val result: String?=null,
)