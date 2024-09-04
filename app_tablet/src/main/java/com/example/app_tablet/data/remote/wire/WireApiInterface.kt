package com.example.app_tablet.data.remote.wire

import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.data.model.wire.WireDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WireApiInterface {
    @GET(WireDetails.BASE_URL)
    suspend fun getWire(
        @Query("q", encoded = true) query: String = "the+wire+characters",
        @Query("format") format: String = "json"
    ): WireDataModel

}