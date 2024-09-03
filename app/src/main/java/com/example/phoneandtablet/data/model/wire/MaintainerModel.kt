package com.example.phoneandtablet.data.model.wire


import com.google.gson.annotations.SerializedName

data class MaintainerModel(
    @SerializedName("github")
    val github: String? = ""
)