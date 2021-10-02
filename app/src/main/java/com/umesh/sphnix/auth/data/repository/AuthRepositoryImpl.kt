package com.umesh.sphnix.auth.data.repository

import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.data.model.LoginResponse
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.data.model.SigUpResponse
import com.umesh.sphnix.network.ApiService
import com.umesh.sphnix.auth.data.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private var apiService: ApiService
) : AuthRepository {
    override suspend fun postLogin(loginRequest: LoginRequest): Response<LoginResponse> {
      return apiService.login(loginRequest)
    }

    override suspend fun postSignup(sigUpRequest: SigUpRequest): Response<SigUpResponse> {
     return apiService.signup(sigUpRequest)
    }

}