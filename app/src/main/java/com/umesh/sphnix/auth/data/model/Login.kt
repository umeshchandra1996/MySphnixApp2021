package com.umesh.sphnix.auth.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val message: String?="",
    val data: String?="",
    val error: String?="",
)

data class LoginRequest(
    @SerializedName("email")
    val email:String,
    @SerializedName("password")
    val pass:String
)