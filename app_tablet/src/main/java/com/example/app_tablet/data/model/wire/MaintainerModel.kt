package com.example.app_tablet.data.model.wire


import com.google.gson.annotations.SerializedName

data class MaintainerModel(
    @SerializedName("github")
    val github: String? = ""
)