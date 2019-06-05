package com.example.finance.ui.dialog.rename

import com.example.finance.data.ContactModel

interface RenameContactView {
    fun renameContact(model: ContactModel)
    fun onContactRenamed()
    fun showMessage(message: String)
    fun showMessage(message: Int)
}