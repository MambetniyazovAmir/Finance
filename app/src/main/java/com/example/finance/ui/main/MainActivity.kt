package com.example.finance.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDatabase
import com.example.finance.ui.main.list.ListAdapter
import com.example.finance.ui.dialog.contact.AddContactDialog
import com.example.finance.ui.dialog.contact.OnContactAddedListener
import com.example.finance.ui.main.list.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val adapter = ListAdapter()
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addContactBtn.attachToRecyclerView(listView)
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        addContactBtn.setOnClickListener {
            val dialog = AddContactDialog(this)
            dialog.setOnContactAddedListener(onContactAddedListener)
            dialog.show()
        }
        presenter = MainPresenter(FinanceDatabase.getInstance(this).financeDao(), this)
        presenter.getAllContacts()

        val toolBar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolBar)
/*        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.menu.menu)*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.sortBtn -> {

            }
            R.id.menu1 -> {
                addContactBtn.callOnClick()
            }
            R.id.menu2 -> {

            }
            R.id.menu3 -> {

            }
            R.id.sumIcon -> {

            }
        }
        return false
    }

    private val onContactAddedListener: OnContactAddedListener = object: OnContactAddedListener {
        override fun contactAdded() {
            presenter.getAllContacts()
        }
    }

    override fun setData(contacts: List<ContactModel>) {
        adapter.setData(contacts)
    }

    override fun setTotalAmount(totalAmount: Double) {

    }
}
