package com.example.letssopt.auth


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<T>(
    @SerialName("success")
    val success: Boolean,

    @SerialName("status")
    val status: Int,

    @SerialName("message")
    val message: String,

    @SerialName("code")
    val code: String,

    @SerialName("data")
    val data: T? = null,

    @SerialName("meta")
    val meta: Metadata? = null
)

@Serializable
data class Metadata(
    @SerialName("path")
    val path: String,

    @SerialName("timestamp")
    val timestamp: String
)