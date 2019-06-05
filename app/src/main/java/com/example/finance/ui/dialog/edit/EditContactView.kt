package com.example.finance.ui.dialog.edit

interface EditContactView {
    fun onContactEdited()
    fun showMessage(msg: String)
    fun showMessage(msg: Int)
}