package com.example.phoneandtablet.data.model.simpson


import com.google.gson.annotations.SerializedName

data class RelatedTopicModel(
    @SerializedName("FirstURL")
    val firstURL: String? = "",
    @SerializedName("Icon")
    val icon: IconModel? = IconModel(),
    @SerializedName("Result")
    val result: String? = "",
    @SerializedName("Text")
    val text: String? = ""
)