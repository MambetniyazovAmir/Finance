package com.example.finance.ui.dialog.contact

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.FinanceDatabase
import kotlinx.android.synthetic.main.dialog_add_contact.*

class AddContactDialog(context: Context) : Dialog(context), AddContactView {

    lateinit var presenter: AddContactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_contact)
        checkBoxId.setOnCheckedChangeListener { _, isChecked ->
            when(isChecked) {
                true -> {
                    Layout.visibility = View.GONE
                    additionLayout.visibility = View.VISIBLE
                }
                false -> {
                    additionLayout.visibility = View.GONE
                    Layout.visibility = View.VISIBLE
                }
            }
        }

        presenter = AddContactPresenter(FinanceDatabase.getInstance(context).financeDao(), this)
    }

    override fun close() {
        dismiss()
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}