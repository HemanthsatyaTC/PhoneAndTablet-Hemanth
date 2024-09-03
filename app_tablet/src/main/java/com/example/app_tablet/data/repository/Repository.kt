package com.example.app_tablet.data.repository

import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire

interface Repository {
    suspend fun getSimpson(query:String, format:String): RelatedTopicModel
    suspend fun getWire(query:String, format:String): RelatedTopicModelWire
}