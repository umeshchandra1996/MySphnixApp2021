package com.umesh.sphnix.auth.persentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.umesh.sphnix.R
import com.umesh.sphnix.auth.data.model.LoginRequest
import com.umesh.sphnix.auth.persentation.viewmodel.LoginViewModel
import com.umesh.sphnix.dashboard.persentation.ui.DashBoardActivity
import com.umesh.sphnix.databinding.ActivityLoginBinding
import com.umesh.sphnix.resource.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val loginRequest = LoginRequest(
            email = binding.etEmail.text.toString().trim(),
            pass = binding.etPassword.text.toString().trim()
        )
        binding.btnLogin.setOnClickListener {
            runBlocking {
                viewModel.getPostLogin(loginRequest)
                viewModel.getLoginDataStatus.collectLatest {
                    when (it.status) {
                        Resource.Status.SUCCESS -> {
                            binding.progress.visibility = View.GONE
                            startActivity(Intent(this@LoginActivity, DashBoardActivity::class.java))
                            finish()
                        }
                        Resource.Status.LOADING -> {
                            binding.progress.visibility = View.VISIBLE
                        }

                        Resource.Status.ERROR -> {
                            binding.progress.visibility = View.GONE
                        }

                    }
                }
            }
        }

        binding.signup.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }

    }
}