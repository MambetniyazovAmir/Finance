package com.example.finance.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.finance.R

class AboutDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}
