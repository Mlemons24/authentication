package com.example.authenticationapp.data.model

data class User(
    val id: String,
    val email: String,
    val authToken: String?
)
