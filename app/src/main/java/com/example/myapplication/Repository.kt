package com.example.myapplication

import com.example.myapplication.data.GetData
import com.example.myapplication.data.Posts
import com.example.myapplication.data.utlis.RetrofitInstance
import retrofit2.Response

class Repository {
    /*suspend fun getPost():Posts{
        return RetrofitInstance.api.
    }*/

    suspend fun pushPosts(name: String,address :String,phone :String,oldDue : String,group :String) :Response<Posts>{
        return RetrofitInstance.api.pushPost(name,address,phone,oldDue,group)
    }

    suspend fun getPosts() :Response<List<GetData>>{
        return RetrofitInstance.api.getData()
    }
}

/*
class Repository {
    */
/*suspend fun getPost():Posts{
        return RetrofitInstance.api.
    }*//*


    suspend fun pushPosts(userId:Int,id:Int,tittle:String,body:String) :Response<GetData>{
        return RetrofitInstance.api.pushPost(userId,id,tittle,body)
    }

   */
/* suspend fun getPosts() :Response<List<Posts>>{
        return RetrofitInstance.api.getPosts()
    }*//*

    suspend fun getData() :Response<List<GetData>>{
        return RetrofitInstance.api.getData()
    }
}*/
