package com.example.mvvmarchietucture.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val retrofitInstance: ApiInterface = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BaseURL.API_BASE_URL)
            .build()
            .create(ApiInterface::class.java)
}