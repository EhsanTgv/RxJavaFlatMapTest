package com.taghavi.rxjavaflatmaptest.requests

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {
    val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofitBuilder: Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = retrofitBuilder.build()

    private val requestAPI: RequestApi = retrofit.create(RequestApi::class.java)

    fun getRequestApi(): RequestApi {
        return requestAPI
    }
}