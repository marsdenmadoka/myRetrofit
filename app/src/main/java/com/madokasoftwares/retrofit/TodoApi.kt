package com.madokasoftwares.retrofit

import retrofit2.Response
import retrofit2.http.GET


//this interface we define all the functions we need to access our Api
interface TodoApi {
  @GET("/todos")  //the string is what comes after our base URL http://jsonplaceholder.typicode.com/todos
suspend  fun getTodos():Response<List<Todo>> //oTodo is our data class here
//we use the suspend keyword since we want to execute our function in a coroutines

}










/**
//at times we are required to pass a query parameter e.g the Api key
//fun getTodos(@Query("key") key:String):Response<List<Todo>>

//if you want to post some json data to a server
//@POST("/createTodo")
//fun createTodo(@Body todo: Todo):Response<List<Todo>>


//types of request
//        post
//        get
//        delete
//        put
        **/