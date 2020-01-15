package com.example.finance.ui.main

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PopupMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.finance.R
import com.example.finance.data.ContactModel
import com.example.finance.data.FinanceDatabase
import com.example.finance.helper.SharedPreferencesHelper
import com.example.finance.ui.dialog.AboutDialog
import com.example.finance.ui.main.list.ListAdapter
import com.example.finance.ui.dialog.contact.AddContactDialog
import com.example.finance.ui.dialog.contact.OnContactAddedListener
import com.example.finance.ui.dialog.edit.EditContact
import com.example.finance.ui.dialog.edit.OnContactEditedListener
import com.example.finance.ui.dialog.rename.OnContactRenamedListener
import com.example.finance.ui.dialog.rename.RenameContactDialog
import com.example.finance.ui.dialog.settings.SettingsDialog
import com.example.finance.ui.main.list.OnContactItemClickListener
import com.example.finance.ui.password.PasswordActivity
import kotlinx.android.synthetic.main.activity_settings_dialog.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), MainView, OnContactItemClickListener, OnContactRenamedListener, OnContactEditedListener {
    private val adapter = ListAdapter()
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        addContactBtn.attachToRecyclerView(listView)
        listView.adapter = adapter
        listView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        addContactBtn.setOnClickListener {
            val dialog = AddContactDialog(this)
            dialog.setOnContactAddedListener(onContactAddedListener)
            dialog.show()
        }
        adapter.setOnContactItemClickListener(this)
        presenter = MainPresenter(FinanceDatabase.getInstance(this).financeDao(), this, SharedPreferencesHelper(this))
        presenter.getAllContacts()
        presenter.getSum()
        presenter.isLocked()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    var sortBoolean = true
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.sortBtn -> {
                sortBoolean = !sortBoolean
                presenter.sortContacts(sortBoolean)
            }
            R.id.menu1 -> {
                addContactBtn.callOnClick()
                return true
            }
            R.id.menu2 -> {
                val settingsDialog = SettingsDialog(this)
                settingsDialog.show()
            }
            R.id.menu3 -> {
                val about = AboutDialog(this)
                about.show()
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
        amountText.text = totalAmount.toString()
        if(totalAmount<0) amountText.setTextColor(Color.RED)
        else amountText.setTextColor(Color.GREEN)
    }
    override fun onItemClick(view: View, model: ContactModel) {
        val popupMenu = PopupMenu(this,view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
        popupMenu.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when(it.itemId){
                R.id.editBalance -> {
                    val editDialog = EditContact(this, model, this)
                    editDialog.show()
                    true
                }
                R.id.repayFullAmount -> {
                    model.amount = 0.0
                    presenter.updateContact(model)
                    presenter.getSum()
                    true
                }
                R.id.deleteContact -> {
                    presenter.deleteContact(model)
                    true
                }
                R.id.rename -> {
                    val renameDialog = RenameContactDialog(this, model, this)
                    renameDialog.show()
//                    presenter.getAllContacts()
                    true
                }
                else -> {
                    false
                }
            }
        }
        popupMenu.show()
    }

    override fun openPasswordActivity() {
        startActivity(Intent(this, PasswordActivity::class.java))
    }

    override fun onContactRenamed() {
        presenter.getAllContacts()
        presenter.getSum()
    }

    override fun contactEdited() {
        presenter.getAllContacts()
        presenter.getSum()
    }
}
