package com.example.finance.ui.dialog.rename

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDatabase
import kotlinx.android.synthetic.main.rename_contact.*

class RenameContactDialog(context: Context, private val model: ContactModel, private val callback: OnContactRenamedListener): Dialog(context), RenameContactView{
    lateinit var presenter: RenameContactPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rename_contact)
        oldName.text = model.name
        presenter = RenameContactPresenter(FinanceDatabase.getInstance(context).financeDao(),this)
        okBtn.setOnClickListener {
            renameContact(model)
        }
        cancelBtn.setOnClickListener {
            dismiss()
        }
    }

    override fun renameContact(model: ContactModel) {
        if (newName.text.isNullOrEmpty()) {
            showMessage(R.string.you_have_not_inputted_name)
            return
        }
        model.name = newName.text.toString()
        presenter.updateModel(model)
    }

    override fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onContactRenamed() {
        callback.onContactRenamed()
        dismiss()
    }
}