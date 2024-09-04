package com.example.phoneandtablet.data.remote.wire

import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.data.model.wire.WireDataModel
import com.example.phoneandtablet.data.remote.simpson.SimpsonDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface WireApiInterface {
    @GET(WireDetails.BASE_URL)
    suspend fun getWire(
        @Query("q", encoded = true) query: String = "the+wire+characters",
        @Query("format") format: String = "json"
    ): WireDataModel
}