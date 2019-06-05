package com.example.finance.ui.dialog.edit

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao
import com.example.finance.data.FinanceDatabase
import kotlinx.android.synthetic.main.activity_edit_contact.*

class EditContact(context: Context, private var model: ContactModel, private var callback: OnContactEditedListener) : Dialog(context), EditContactView {
    lateinit var presenter : EditContactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)
        if (model.amount > 0.0) balance.setTextColor(Color.GREEN)
        if (model.amount < 0.0) balance.setTextColor(Color.RED)
        if (model.amount == 0.0) balance.setTextColor(Color.GRAY)
        balance.text = model.amount.toString()
        presenter = EditContactPresenter(FinanceDatabase.getInstance(context).financeDao(), this)
        plusButton.setOnClickListener {
            presenter.plusAmount(model, etAmount.text.toString().toDouble(), etComment.text.toString())
        }
        minusButton.setOnClickListener {
            presenter.minusAmount(model, etAmount.text.toString().toDouble(), etComment.text.toString())
        }
        cancelButton.setOnClickListener {
            presenter.cancel()
        }
    }

    override fun onContactEdited() {
        callback.contactEdited()
        dismiss()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
