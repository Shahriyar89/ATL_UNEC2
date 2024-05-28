package com.example.atl_unec2.network

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("message")
    val imageUrl: String?=null,
    @SerializedName("status")
    val result: String?=null,
)