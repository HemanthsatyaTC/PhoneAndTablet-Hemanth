package com.example.phoneandtablet.data.remote.simpson

import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.simpson.SimpsonDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpsonApiInterface {

    @GET(SimpsonDetails.BASE_URL)
    suspend fun getSimpson(
        @Query("q", encoded = true) query: String = "simpsons+characters",
        @Query("format") format: String = "json"
    ): SimpsonDataModel
}