package com.example.phoneandtablet.data.model.simpson


import com.google.gson.annotations.SerializedName

data class DeveloperModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)