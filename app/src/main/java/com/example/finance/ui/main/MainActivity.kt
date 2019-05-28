package com.example.finance.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDatabase
import com.example.finance.ui.main.list.ListAdapter
import com.example.finance.ui.dialog.contact.AddContactDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val adapter = ListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addContactBtn.attachToRecyclerView(listView)
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        addContactBtn.setOnClickListener {
            AddContactDialog(this).show()
        }

        val presenter = MainPresenter(FinanceDatabase.getInstance(this).financeDao(), this)
        presenter.getAllContacts()
    }

    override fun setData(contacts: List<ContactModel>) {
        Toast.makeText(this, "sharapat", Toast.LENGTH_SHORT).show()
    }
}
