package com.ezioapps.retrofitsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezioapps.retrofitsample.models.Post
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val listPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    fun getPost(){
        viewModelScope.launch {

            //val response = repository.getPost()
            myResponse.value = repository.getPost()
        }
    }

    fun getPost(postId : Int){
        viewModelScope.launch {

            //val response = repository.getPost()
            myResponse.value = repository.getPost(postId)
        }
    }

    fun getCustomPost(userId: Int){
        viewModelScope.launch {
            listPosts.value = repository.getCustomPost(userId)
        }
    }

}