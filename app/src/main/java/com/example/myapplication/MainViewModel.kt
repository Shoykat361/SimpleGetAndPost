package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.GetData
import com.example.myapplication.data.Posts
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val myPushResponse : MutableLiveData<Response<Posts>> = MutableLiveData()


    private val _posts = MutableLiveData<List<GetData>>()
    val posts: LiveData<List<GetData>> get() = _posts

    init {
        getPosts()
    }
    private fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            if (response.isSuccessful) {
                _posts.value = response.body()
            } else {
                // Handle error
            }
        }
    }

    fun pushPost(name: String,address :String,phone :String,oldDue : String,group :String){
        viewModelScope.launch {
            val response = repository.pushPosts(name,address,phone,oldDue,group)
            myPushResponse.value = response
        }
    }
}