package com.example.app_tablet.data.model.wire


import com.google.gson.annotations.SerializedName

data class WireDataModel(
    @SerializedName("Abstract")
    val `abstract`: String? = "",
    @SerializedName("AbstractSource")
    val abstractSource: String? = "",
    @SerializedName("AbstractText")
    val abstractText: String? = "",
    @SerializedName("AbstractURL")
    val abstractURL: String? = "",
    @SerializedName("Answer")
    val answer: String? = "",
    @SerializedName("AnswerType")
    val answerType: String? = "",
    @SerializedName("Definition")
    val definition: String? = "",
    @SerializedName("DefinitionSource")
    val definitionSource: String? = "",
    @SerializedName("DefinitionURL")
    val definitionURL: String? = "",
    @SerializedName("Entity")
    val entity: String? = "",
    @SerializedName("Heading")
    val heading: String? = "",
    @SerializedName("Image")
    val image: String? = "",
    @SerializedName("ImageHeight")
    val imageHeight: Int? = 0,
    @SerializedName("ImageIsLogo")
    val imageIsLogo: Int? = 0,
    @SerializedName("ImageWidth")
    val imageWidth: Int? = 0,
    @SerializedName("Infobox")
    val infobox: String? = "",
    @SerializedName("meta")
    val meta: MetaModel? = MetaModel(),
    @SerializedName("Redirect")
    val redirect: String? = "",
    @SerializedName("RelatedTopics")
    val relatedTopics: List<RelatedTopicModelWire?>? = listOf(),
//    @SerializedName("Results")
//    val results: List<AnyModel?>? = listOf(),
    @SerializedName("Type")
    val type: String? = ""
)