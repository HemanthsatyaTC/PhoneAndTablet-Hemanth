package com.example.app_tablet.data.remote.simpson

import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonApiInterface {
    @GET(SimpsonDetails.END_POINTS)
    suspend fun getSimpson(
        @Query("q") query: String = "simpsons+characters",
        @Query("format") format: String = "json"
    ): RelatedTopicModel
}