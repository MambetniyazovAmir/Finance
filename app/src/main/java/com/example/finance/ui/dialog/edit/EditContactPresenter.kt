package com.example.finance.ui.dialog.edit

import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao

class EditContactPresenter(private val dao: FinanceDao, private val view: EditContactView) {
    fun plusAmount(model: ContactModel, amount: Double, comment: String?){
        if (amount == 0.0)
            view.showMessage("Значение не задано или равно нулю")
        else {
            model.amount += amount
            model.comment = comment
            dao.updateContact(model)
            view.onContactEdited()
        }
    }

    fun minusAmount(model: ContactModel, amount: Double, comment: String?){
        if (amount == 0.0)
            view.showMessage("Значение не задано или равно нулю")
        else {
            model.amount -= amount
            model.comment = comment
            dao.updateContact(model)
            view.onContactEdited()
        }
    }

    fun cancel(){
        view.onContactEdited()
    }
}