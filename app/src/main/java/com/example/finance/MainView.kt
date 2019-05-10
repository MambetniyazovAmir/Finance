package com.example.finance

import com.example.finance.data.ContactModel

interface MainView {
    fun setData(contacts: List<ContactModel>)
}