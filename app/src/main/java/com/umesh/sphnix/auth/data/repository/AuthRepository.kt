package com.umesh.sphnix.auth.data.repository

import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.data.model.LoginResponse
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.data.model.SigUpResponse
import retrofit2.Response

interface AuthRepository {
    suspend fun postLogin(loginRequest: LoginRequest): Response<LoginResponse>
    suspend fun postSignup(sigUpRequest: SigUpRequest): Response<SigUpResponse>

}