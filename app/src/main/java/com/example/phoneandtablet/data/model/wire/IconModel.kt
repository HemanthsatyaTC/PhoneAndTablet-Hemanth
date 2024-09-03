package com.example.phoneandtablet.data.model.wire


import com.google.gson.annotations.SerializedName

data class IconModel(
    @SerializedName("Height")
    val height: String? = "",
    @SerializedName("URL")
    val uRL: String? = "",
    @SerializedName("Width")
    val width: String? = ""
)