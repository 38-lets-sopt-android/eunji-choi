package com.example.letssopt.signup

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    @SerialName("loginId")
    val loginId: String,
    @SerialName("password")
    val password: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("age")
    val age: Int,
    @SerialName("part")
    val part: String
)

@Serializable
data class SignUpResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String,
    @SerialName("meta")
    val meta: SignUpMeta? = null
)

@Serializable
data class SignUpMeta(
    @SerialName("path")
    val path: String,
    @SerialName("timestamp")
    val timestamp: String
)