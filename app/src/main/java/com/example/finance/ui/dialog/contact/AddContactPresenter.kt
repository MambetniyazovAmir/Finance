package com.example.finance.ui.dialog.contact

import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao

class AddContactPresenter(private val dao: FinanceDao, private val view: AddContactView) {

    fun addContact(name: String) {
        if (name.isEmpty()) {
            view.showMessage(R.string.you_have_not_inputted_name)
        } else {
            val newContact = ContactModel()
            newContact.name = name
            dao.insertToDB(newContact)
            view.close()
        }
    }

    fun cancel() {
        view.close()
    }
}