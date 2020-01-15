package com.example.finance.ui.dialog.settings

import com.example.finance.helper.SharedPreferencesHelper

class SettingsPresenter(private val helper: SharedPreferencesHelper, private val view: SettingsView) {

    fun setLocked(isLocked: Boolean){
        helper.setLocked(isLocked)
    }

    fun isPasswordSet(): Boolean{
        return helper.isCorrectPassword() != 0
    }
}