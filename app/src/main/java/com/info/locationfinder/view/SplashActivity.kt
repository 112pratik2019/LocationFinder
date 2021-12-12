package com.info.locationfinder.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.info.locationfinder.databinding.ActivitySplashBinding
import com.info.locationfinder.view.util.UserPreferences
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding= ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(splashBinding.root)

        val activity = if(UserPreferences.isUserRegistered())  DashboardActivity::class.java else SignInActivity::class.java
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        lifecycleScope.launch {
            delay(1000)
            startActivity(intent)
            finish()
        }
    }

}