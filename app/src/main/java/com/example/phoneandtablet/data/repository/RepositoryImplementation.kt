package com.example.phoneandtablet.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.simpson.SimpsonDataModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.data.model.wire.WireDataModel
import com.example.phoneandtablet.data.remote.simpson.SimpsonApiInterface
import com.example.phoneandtablet.data.remote.wire.WireApiInterface
import javax.inject.Inject

class RepositoryImplementation @Inject constructor (
    val apiSimpsons: SimpsonApiInterface,
    val apiWire: WireApiInterface
) : Repository {
    @SuppressLint("SuspiciousIndentation")
    override suspend fun getSimpson(query: String, format: String): SimpsonDataModel {
        val response = apiSimpsons.getSimpson("simpsons+characters", "json")
        return response
    }

    override suspend fun getWire(query: String, format: String): WireDataModel {
        val wireResponse = apiWire.getWire("the+wire+characters", "json")
        return wireResponse
    }
}