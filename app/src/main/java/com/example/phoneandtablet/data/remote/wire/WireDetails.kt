package com.example.phoneandtablet.data.remote.wire

import com.example.phoneandtablet.data.remote.simpson.SimpsonApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WireDetails {

//    https://api.duckduckgo.com/?q=the+wire+characters&format=json

    const val BASE_URL= "https://api.duckduckgo.com/"
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
        .create(WireApiInterface::class.java)
}