package com.example.islamic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islamic.databinding.ActivitySplashScreenBinding
import com.example.islamic.ui.MainActivity

class Splash_Screen : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        initViews()

    }

    private fun initViews() {
        startSplash()

    }

    private fun startSplash() {

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}