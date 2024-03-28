package com.example.myapplication.data.utlis

import com.example.myapplication.data.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//const val Base_Url = "https://jsonplaceholder.typicode.com/"
const val Base_Url = "https://billing.softhostit.com/api/"

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api :Api by lazy {
        retrofit.create(Api::class.java)
    }
}