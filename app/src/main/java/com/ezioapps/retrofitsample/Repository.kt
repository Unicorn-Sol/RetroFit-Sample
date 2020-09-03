package com.ezioapps.retrofitsample

import com.ezioapps.retrofitsample.models.Post
import retrofit2.Response
import retrofit2.http.Query

class Repository {


    suspend fun getPost( ): Response<Post> {
        return RetrofitInstance.api.getPost()
    }


    suspend fun getPost(postId : Int): Response<Post> {
        return RetrofitInstance.api.getPost(postId)
    }

    suspend fun getCustomPost(userId : Int) : Response<List<Post>>{
        return RetrofitInstance.api.getCustomPost(userId)
    }
}