package com.example.phoneandtablet.data.remote.wire

import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.data.remote.simpson.SimpsonDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface WireApiInterface {
    @GET(WireDetails.END_POINTS)
    suspend fun getWire(
        @Query("q") query: String = "the+wire+characters",
        @Query("format") format: String = "json"
    ): RelatedTopicModelWire
}