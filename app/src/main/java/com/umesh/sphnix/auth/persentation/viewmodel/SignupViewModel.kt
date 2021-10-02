package com.umesh.sphnix.auth.persentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.data.model.SigUpResponse
import com.umesh.sphnix.auth.data.repository.AuthRepository
import com.umesh.sphnix.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private var useCase:AuthRepository):ViewModel(){
    private val _getSignupDataStatus = MutableLiveData<Resource<Response<SigUpResponse>>>(Resource.loading(null))
    val getSignupDataStatus: LiveData<Resource<Response<SigUpResponse>>> =_getSignupDataStatus

     fun getPostSignup(sigUpRequest: SigUpRequest) {
        viewModelScope.launch {
            _getSignupDataStatus.value = (Resource.loading(null))
            try {
                val data = useCase.postSignup(sigUpRequest)
                _getSignupDataStatus.value = (Resource.success(data, 0))
            } catch (exception: Exception) {
                _getSignupDataStatus.value = (Resource.error(null, exception.message ?: ""))
            }
        }
    }

}