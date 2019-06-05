package com.example.finance.ui.dialog.rename

import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao

class RenameContactPresenter(private val dao: FinanceDao, private val view: RenameContactView) {
    fun updateModel(model: ContactModel){
        dao.updateContact(model)
        view.onContactRenamed()
    }


}