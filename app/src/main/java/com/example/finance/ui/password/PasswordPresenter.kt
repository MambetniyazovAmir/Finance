package com.example.finance.ui.password

import com.example.finance.helper.SharedPreferencesHelper

class PasswordPresenter(private val helper: SharedPreferencesHelper, private val view: PasswordView) {
    private fun setPassword(password: Int){
        helper.setPassword(password)
    }
    fun isCorrectPassword(password: Int) {
        if (helper.isCorrectPassword() == 0) {
            setPassword(password)
        } else {
            if (password==helper.isCorrectPassword())
            view.openMainActivity()
        }
    }
}