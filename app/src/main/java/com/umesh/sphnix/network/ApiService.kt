package com.umesh.sphnix.network

import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.data.model.LoginResponse
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.data.model.SigUpResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("login-user")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
    @POST("signup")
    suspend fun signup(@Body sigUpRequest: SigUpRequest): Response<SigUpResponse>
}