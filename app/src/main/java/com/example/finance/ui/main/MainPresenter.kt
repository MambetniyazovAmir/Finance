package com.example.finance.ui.main
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao

class MainPresenter (private val dao: FinanceDao, private val view: MainView){

    fun getAllContacts() {
        view.setData(dao.getAllContacts())
    }
    fun getSum() {
        var totalAmount = 0.0
        dao.getAllContacts().forEach {
            totalAmount += it.amount
        }
        view.setTotalAmount(totalAmount)
    }
    fun deleteContact(model: ContactModel){
        dao.deleteContact(model)
        getAllContacts()
        getSum()
    }
    fun updateContact(model: ContactModel){
        dao.updateContact(model)
        getAllContacts()
    }
    fun sortContacts(boolean: Boolean) {
        if (boolean)
            view.setData(dao.sortByName())
        else
            view.setData(dao.sortByAmount())
    }
}