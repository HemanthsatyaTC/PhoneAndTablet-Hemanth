package com.example.app_tablet.data.repository

import android.util.Log
import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.data.remote.simpson.SimpsonApiInterface
import com.example.app_tablet.data.remote.wire.WireApiInterface
import javax.inject.Inject

class RepositoryImplementation@Inject constructor (
    val apiSimpsons: SimpsonApiInterface,
    val apiWire: WireApiInterface
) : Repository {
    override suspend fun getSimpson(query: String, format: String): RelatedTopicModel {
        val response = apiSimpsons.getSimpson("simpsons+characters", "json")
        Log.d("Repository", "Raw API Response: $response")
        return response
    }

    override suspend fun getWire(query: String, format: String): RelatedTopicModelWire {
        val wireResponse = apiWire.getWire("the+wire+characters", "json")
        Log.d("Repository", "Raw API Response: $wireResponse")
        return wireResponse
    }
}