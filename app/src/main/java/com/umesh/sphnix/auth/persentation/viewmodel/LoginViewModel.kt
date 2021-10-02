package com.umesh.sphnix.auth.persentation.viewmodel

import androidx.lifecycle.ViewModel
import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.data.model.LoginResponse
import com.umesh.sphnix.resource.Resource
import com.umesh.sphnix.auth.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private var useCase: AuthUseCase):ViewModel(){
    private val _getLoginDataStatus = MutableStateFlow<Resource <Response<LoginResponse>>>(Resource.loading(null))
    val getLoginDataStatus: StateFlow<Resource<Response<LoginResponse>>> = _getLoginDataStatus

    suspend fun getPostLogin(loginRequest: LoginRequest) {
            _getLoginDataStatus.value=(Resource.loading(null))
            try {
                val data = useCase.postLogin(loginRequest)
                _getLoginDataStatus.value=(Resource.success(data, 0))
            } catch (exception: Exception) {
                _getLoginDataStatus.value=(Resource.error(null, exception.message?:""))
            }
    }

}