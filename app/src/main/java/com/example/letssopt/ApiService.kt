package com.example.letssopt

import com.example.letssopt.login.LoginRequestDto
import com.example.letssopt.login.LoginResponseDto
import com.example.letssopt.signup.SignUpRequestDto
import com.example.letssopt.signup.SignUpResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/auth/signup")
    suspend fun signUp(@Body request: SignUpRequestDto): Response<SignUpResponseDto>

    @POST("api/v1/auth/signin")
    suspend fun logIn(@Body request: LoginRequestDto): Response<LoginResponseDto>
}