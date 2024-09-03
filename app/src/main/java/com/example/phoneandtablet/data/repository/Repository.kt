package com.example.phoneandtablet.data.repository

import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.simpson.SimpsonDataModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import retrofit2.http.Query

interface Repository {
    suspend fun getSimpson(query:String, format:String): SimpsonDataModel
    suspend fun getWire(query:String, format:String): RelatedTopicModelWire
}