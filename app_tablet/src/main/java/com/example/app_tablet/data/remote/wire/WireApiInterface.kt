package com.example.app_tablet.data.remote.wire

import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import retrofit2.http.GET
import retrofit2.http.Query

interface WireApiInterface {
    @GET(WireDetails.END_POINTS)
    suspend fun getWire(
        @Query("q") query: String = "the+wire+characters",
        @Query("format") format: String = "json"
    ): RelatedTopicModelWire

}