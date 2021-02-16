package com.madokasoftwares.retrofit

//this is our data class
data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)