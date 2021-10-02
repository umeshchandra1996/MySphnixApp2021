package com.umesh.sphnix.auth.data.model

data class SigUpResponse(
    val message: String?="",
    val data: String?="",
    val error: String?="",
)

data class SigUpRequest(
    val email: String,
    val pass: String,
    val mobileNum: String,
    val username: String,
    val user_type:String
)