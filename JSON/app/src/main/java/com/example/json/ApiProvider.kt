package com.example.json

import retrofit2.Call
import retrofit2.http.GET

interface ApiProvider {

    @GET("/photos")
    fun getPosts(): Call<MutableList<PostModel>>

}
