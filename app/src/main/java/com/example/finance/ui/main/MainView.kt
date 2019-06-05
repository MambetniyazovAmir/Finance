package com.example.finance.ui.main

import android.support.v7.widget.Toolbar
import com.example.finance.data.ContactModel

interface MainView {
    fun setData(contacts: List<ContactModel>)
    fun setTotalAmount(totalAmount: Double)
}