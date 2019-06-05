package com.example.finance.ui.dialog.contact

import android.util.Log
import android.widget.Toast
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
            view.updateView()
            view.close()
        }
    }
    fun plusAmount(name: String, double: Double, comment: String?){
        if (name.isEmpty()) {
            view.showMessage(R.string.you_have_not_inputted_name)
//            return
        }
        else{
            val contactModel = dao.check(name)
            if(contactModel != null){
                contactModel.amount += double
                if (comment != null) {
                    contactModel.comment = comment
                }
                dao.updateContact(contactModel)
                view.updateView()
                view.close()
            }
            else{
                val newContact = ContactModel()
                newContact.name = name
                newContact.amount = double
                if (comment != null) {
                    newContact.comment = comment
                }
                dao.insertToDB(newContact)
                view.updateView()
                view.close()
            }
        }
    }
    fun minusAmount(name: String, double: Double, comment: String?){
        if (name.isEmpty()) {
            view.showMessage(R.string.you_have_not_inputted_name)
            return
        }
        val contactModel = dao.check(name)
        if(contactModel != null){
            contactModel.amount -= double
            Log.d("amount", double.toString())
            dao.updateContact(contactModel)
            if (comment != null) {
                contactModel.comment = comment
            }
            view.updateView()
            view.close()
        }
        else{
            val newContact = ContactModel()
            newContact.name = name
            newContact.amount -= double
            if (comment != null) {
                newContact.comment = comment
            }
            Log.d("amount", double.toString())

            dao.insertToDB(newContact)
            view.updateView()
            view.close()
        }
    }
    fun cancel() {
        view.close()
    }
}