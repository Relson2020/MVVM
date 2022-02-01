package com.example.mvvmarchietucture.model

import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    suspend fun getData() : List<MyDataItem>

}