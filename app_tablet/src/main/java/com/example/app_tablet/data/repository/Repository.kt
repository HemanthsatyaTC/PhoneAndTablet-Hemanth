package com.example.app_tablet.data.repository

import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.data.model.simpson.SimpsonDataModel
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.data.model.wire.WireDataModel

interface Repository {
    suspend fun getSimpson(query:String, format:String): SimpsonDataModel
    suspend fun getWire(query:String, format:String): WireDataModel
}