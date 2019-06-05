package com.example.finance.ui.dialog.contact

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.FinanceDatabase
import com.example.finance.ui.main.MainActivity
import com.example.finance.ui.main.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add_contact.*
import kotlinx.android.synthetic.main.item.*

class AddContactDialog(context: Context) : Dialog(context), AddContactView {
    lateinit var presenter: AddContactPresenter
    private var onContactAddedListener: OnContactAddedListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_contact)
        checkBoxId.isChecked = false
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
        addBalanceTextView.setOnClickListener {
            checkBoxId.isChecked = !checkBoxId.isChecked
        }
        presenter = AddContactPresenter(FinanceDatabase.getInstance(context).financeDao(), this)
        addButton.setOnClickListener {
            presenter.addContact(newContactName.text.toString())
        }
        plusButton.setOnClickListener {
            if (amountId.text.isEmpty() && commentId.text.isEmpty()){
                presenter.addContact(newContactName.text.toString())
                return@setOnClickListener
            }

            if (amountId.text.isEmpty()){
                showMessage(R.string.you_have_not_inputted_name)
                return@setOnClickListener
            }
            presenter.plusAmount(newContactName.text.toString(), amountId.text.toString().toDouble(), commentId.text.toString())
        }
        minusButton.setOnClickListener {
            if (amountId.text.isEmpty() && commentId.text.isEmpty()){
                presenter.addContact(newContactName.text.toString())
                return@setOnClickListener
            }
            if (amountId.text.isEmpty()){
                showMessage(R.string.you_have_not_inputted_name)
                return@setOnClickListener
            }
            presenter.minusAmount(newContactName.text.toString(), amountId.text.toString().toDouble(), commentId.text.toString())
        }
        cancelButton.setOnClickListener {
            cancel()
        }
        cancelButton1.setOnClickListener {
            presenter.cancel()
        }
    }

    fun setOnContactAddedListener(onContactAddedListener: OnContactAddedListener) {
        this.onContactAddedListener = onContactAddedListener
    }

    override fun updateView() {
        onContactAddedListener?.contactAdded()
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