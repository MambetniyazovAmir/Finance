package com.example.finance.ui.main

import com.example.finance.data.ContactModel

interface MainView {
    fun setData(contacts: List<ContactModel>)
}