package com.example.apitest

import retrofit2.Call
import retrofit2.http.GET

interface ApiProvider {

    @GET("/users")
    fun getPosts(): Call<MutableList<PostModel>>
}