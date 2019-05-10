package com.example.finance

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDao
import com.example.finance.data.FinanceDatabase
import com.example.finance.list.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val adapter = ListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val view: MainView = object: MainView {
            override fun setData(contacts: List<ContactModel>) {
                Toast.makeText(this@MainActivity, "amir", Toast.LENGTH_SHORT).show()
            }
        }

        val presenter = MainPresenter(FinanceDatabase.getInstance(this).financeDao(), this)
        presenter.getAllContacts()
    }

    override fun setData(contacts: List<ContactModel>) {
        Toast.makeText(this, "sharapat", Toast.LENGTH_SHORT).show()
    }
}
