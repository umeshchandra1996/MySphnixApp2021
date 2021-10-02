package com.umesh.sphnix.auth.persentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.umesh.sphnix.R
import com.umesh.sphnix.auth.data.model.SigUpRequest
import com.umesh.sphnix.auth.persentation.viewmodel.SignupViewModel
import com.umesh.sphnix.dashboard.persentation.ui.DashBoardActivity
import com.umesh.sphnix.databinding.ActivitySignupBinding
import com.umesh.sphnix.resource.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    private val viewModel: SignupViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.imBack.setOnClickListener {
            finish()
        }
        val sigUpRequest = SigUpRequest(
            email = binding.etEmail.text.toString().trim(),
            mobileNum = binding.etMobile.text.toString().trim(),
            pass = binding.etPassword.text.toString().trim(),
            username = binding.etUsername.text.toString().trim(),
            user_type = "Customer"
        )
        binding.btnReg.setOnClickListener {
            viewModel.getPostSignup(sigUpRequest)
            viewModel.getSignupDataStatus.observe(this, Observer {
                when (it.status) {
                    Resource.Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        startActivity(Intent(this, DashBoardActivity::class.java))
                        finish()
                    }
                    Resource.Status.ERROR -> {
                        binding.progress.visibility = View.GONE
                    }
                    Resource.Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }

                }
            })
        }
    }
}