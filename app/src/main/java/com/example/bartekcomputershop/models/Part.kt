package com.example.bartekcomputershop.models

import com.google.gson.annotations.SerializedName

data class Part(
    @SerializedName("name")
    val title: String,

    @SerializedName("photo_url")
    val photoUrl: String,

    val price:Double,

    val isOnSale: Boolean
)
