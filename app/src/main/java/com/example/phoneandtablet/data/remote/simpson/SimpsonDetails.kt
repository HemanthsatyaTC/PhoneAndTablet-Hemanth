package com.example.phoneandtablet.data.remote.simpson

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SimpsonDetails {
    //http://api.duckduckgo.com/?q=simpsons+characters&format=json

    const val BASE_URL= "http://api.duckduckgo.com/"
    const val END_POINTS = ""

    val retrofitDetails = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .build()
        .create(SimpsonApiInterface::class.java)

}