package com.example.letssopt

import com.example.letssopt.auth.BaseResponseDto
import com.example.letssopt.auth.login.LoginRequestDto
import com.example.letssopt.auth.login.LoginResponseDto
import com.example.letssopt.auth.signup.SignUpRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/auth/signup")
    suspend fun signUp(@Body request: SignUpRequestDto): Response<BaseResponseDto<Unit>>

    @POST("api/v1/auth/signin")
    suspend fun logIn(@Body request: LoginRequestDto): Response<BaseResponseDto<LoginResponseDto>>
}