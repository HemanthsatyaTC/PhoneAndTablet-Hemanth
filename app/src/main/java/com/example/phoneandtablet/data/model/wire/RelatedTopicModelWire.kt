package com.example.phoneandtablet.data.model.wire


import com.google.gson.annotations.SerializedName

data class RelatedTopicModelWire(
    @SerializedName("FirstURL")
    val firstURL: String? = "",
    @SerializedName("Icon")
    val icon: IconModel? = IconModel(),
    @SerializedName("Result")
    val result: String? = "",
    @SerializedName("Text")
    val text: String? = ""
)