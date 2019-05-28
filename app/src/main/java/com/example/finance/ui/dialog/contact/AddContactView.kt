package com.example.finance.ui.dialog.contact

interface AddContactView {
    fun close()
    fun updateView()
    fun showMessage(message: String)
    fun showMessage(message: Int)
}