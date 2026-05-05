package com.example.letssopt

import com.example.letssopt.login.LoginRequest
import com.example.letssopt.login.LoginResponse
import com.example.letssopt.signup.SignUpRequest
import com.example.letssopt.signup.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("api/v1/auth/signin")
    suspend fun logIn(@Body request: LoginRequest): Response<LoginResponse>
}