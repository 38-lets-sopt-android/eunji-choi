package com.example.letssopt.login


import com.example.letssopt.signup.Metadata
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
    @SerialName("success")
    val success: Boolean,

    @SerialName("status")
    val status: Int,

    @SerialName("message")
    val message: String,

    @SerialName("code")
    val code: String,

    @SerialName("data")
    val data: LoginData? = null,

    @SerialName("meta")
    val meta: Metadata? = null
)

@Serializable
data class LoginData(
    @SerialName("userId")
    val userId: Int
)