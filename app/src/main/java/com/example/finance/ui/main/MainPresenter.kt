package com.example.finance.ui.main
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
}