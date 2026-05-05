package com.example.letssopt.login


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("loginId")
    val loginId: String,
    @SerialName("password")
    val password: String
)

@Serializable
data class LoginResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String,
    @SerialName("data")
    val data: LoginData
)

@Serializable
data class LoginData(
    @SerialName("userId")
    val userId: Int
)