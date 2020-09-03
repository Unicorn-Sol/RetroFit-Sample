package com.ezioapps.retrofitsample

import com.ezioapps.retrofitsample.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    }
    val api : MyApi by lazy { retrofit.create(MyApi::class.java) }
}