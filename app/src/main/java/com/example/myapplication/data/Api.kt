package com.example.myapplication.data

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("demo-customer")
    suspend fun pushPost(
        @Field("name") name: String?,
        @Field("address") address: String?,
        @Field("phone") phone: String?,
        @Field("old_due") oldDue: String?,
        @Field("group") group: String?,

    ) : Response<Posts>

   /* @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>*/

    @GET("demo-customer/list")
    suspend fun getData(): Response<List<GetData>>



}