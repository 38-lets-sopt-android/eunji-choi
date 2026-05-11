package com.example.letssopt.auth.login



import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    @SerialName("loginId")
    val loginId: String,

    @SerialName("password")
    val password: String
)

@Serializable
data class LoginResponseDto(
    @SerialName("userId")
    val userId: Int
)