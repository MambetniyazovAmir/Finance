package com.example.finance.ui.main.list

import android.view.View
import com.example.finance.data.ContactModel

interface OnContactItemClickListener {
    fun onItemClick(view: View, model: ContactModel)
}