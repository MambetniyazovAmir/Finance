package com.example.finance
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao

class MainPresenter (private val dao: FinanceDao, private val view: MainView){

    fun getAllContacts() {
        view.setData(dao.getAllContacts())
    }

    fun addContact(contact: ContactModel) {

    }
}