package com.ezioapps.retrofitsample

import com.ezioapps.retrofitsample.models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postId}")
    suspend fun getPost(
        @Path("postId" ) number: Int
    ):Response<Post>

    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId : Int
    ) : Response<List<Post>>
}