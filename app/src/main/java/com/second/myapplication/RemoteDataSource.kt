package com.second.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RestContriesApis {
    @GET("name/{name}")
    suspend fun getContryByName(@Path("name") cityName: String?): List<Contry>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.com/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restContriesApi = retrofit.create<RestContriesApis>(RestContriesApis::class.java)