package com.madokasoftwares.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//create an instance to make the actual requests
object RetrofitInstance {
    val api:TodoApi by lazy{ //by lazy meaning it will be intialized when we access this Api
       Retrofit.Builder()
               .baseUrl("https://jsonplaceholder.typicode.com")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create(TodoApi::class.java) //class of our API


    }

}