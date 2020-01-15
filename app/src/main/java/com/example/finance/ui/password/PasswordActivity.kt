package com.example.finance.ui.password

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.finance.R
import com.example.finance.helper.SharedPreferencesHelper

class PasswordActivity : AppCompatActivity(), PasswordView{
    lateinit var presenter: PasswordPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        presenter = PasswordPresenter(SharedPreferencesHelper(this), this)
    }

    override fun openMainActivity() {

    }
}
