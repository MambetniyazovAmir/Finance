package com.example.finance.helper

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    companion object {
        const val FILE_NAME = "preferences"
        const val IS_LOCKED = "is_locked"
        const val PASSWORD = "password"
    }

    private val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun setLocked(isLocked: Boolean) {
        sharedPreferences.edit().putBoolean(IS_LOCKED, isLocked).apply()
    }

    fun isLocked(): Boolean {
        return sharedPreferences.getBoolean(IS_LOCKED, true)
    }

    fun setPassword(password: Int) {
        sharedPreferences.edit().putInt(PASSWORD, password).apply()
    }

    fun isCorrectPassword(): Int {
        return sharedPreferences.getInt(PASSWORD, 0)
    }
}
