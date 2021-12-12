package com.info.locationfinder.view.util

import android.content.Context
import android.content.SharedPreferences
import com.info.locationfinder.view.App

object UserPreferences {

    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences=  App.applicationContext().getSharedPreferences("user_config", Context.MODE_PRIVATE)
    }

    fun setUserRegistered(isRegistered: Boolean) {
        with(sharedPreferences.edit()) {
            putBoolean("IS_USER_REGISTERED", isRegistered)
            apply()
        }
    }

    fun isUserRegistered() = sharedPreferences.getBoolean("IS_USER_REGISTERED", false)


}