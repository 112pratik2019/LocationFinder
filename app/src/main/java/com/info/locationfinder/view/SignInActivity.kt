package com.info.locationfinder.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.info.locationfinder.databinding.ActivitySignInBinding
import com.info.locationfinder.view.util.UserPreferences
import com.info.locationfinder.view.util.hideKeyboard
import com.info.locationfinder.view.util.showSnackBar

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInBinding=ActivitySignInBinding.inflate(LayoutInflater.from(this))
        setContentView(signInBinding.root)

        signInBinding.btnSignIn.setOnClickListener {
            it.hideKeyboard()
            if(isFieldValidated()){
                UserPreferences.setUserRegistered(true)
                val intent = Intent(this, DashboardActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

    }

    private fun isFieldValidated(): Boolean{
        val nameEdittext = signInBinding.firstnameEditText.text
        val mobNoEdittext = signInBinding.mobileNoEditText.text
        if(TextUtils.isEmpty(nameEdittext)){
            signInBinding.root.showSnackBar(message = "Enter Name !!!")
            return false
        }
        if(TextUtils.isEmpty(mobNoEdittext)){
            signInBinding.root.showSnackBar(message = "Enter Mobile Number !!!")
            return false
        }
        if(mobNoEdittext?.length  != 10){
            signInBinding.root.showSnackBar(message = "Enter Valid Mobile Number !!!")
            return false
        }
        return true
    }


}