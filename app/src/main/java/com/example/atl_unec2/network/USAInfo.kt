package com.example.atl_unec2.network

import com.google.gson.annotations.SerializedName

data class USAInfo(
    @SerializedName("data")
    val data:List<Population>?=null
)

data class Population (
    @SerializedName("ID Nation")
    val nation:String?=null,
    @SerializedName("Nation")
    val nationStates:String?=null,
    @SerializedName("ID Year")
    val idYear:Int?=null,
    @SerializedName("Population")
    val population:String?=null,
    @SerializedName("Slug Nation")
    val slugNation:String?=null,

)
