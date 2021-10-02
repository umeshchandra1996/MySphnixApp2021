package com.umesh.sphnix.auth.domain.usecase
import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.data.model.LoginResponse
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.data.model.SigUpResponse
import com.umesh.sphnix.auth.data.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthUseCaseImpl @Inject constructor(private var repository: AuthRepository ):AuthUseCase {
    override suspend fun postLogin(loginRequest: LoginRequest): Response<LoginResponse> {
       return repository.postLogin(loginRequest = loginRequest)
    }

    override suspend fun postSignup(sigUpRequest: SigUpRequest): Response<SigUpResponse> {
        return repository.postSignup(sigUpRequest=sigUpRequest)
    }


}