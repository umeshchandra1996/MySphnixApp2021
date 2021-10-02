package com.umesh.sphnix

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.umesh.sphnix.auth.persentation.ui.LoginActivity
import com.umesh.sphnix.dashboard.persentation.ui.adapter.MainActivity
import com.umesh.sphnix.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            LoginUI()
        }, 2000)

    }


    private fun LoginUI() {
            startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}