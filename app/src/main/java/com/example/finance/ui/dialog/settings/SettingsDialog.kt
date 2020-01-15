package com.example.finance.ui.dialog.settings

import android.app.Dialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finance.R
import com.example.finance.helper.SharedPreferencesHelper
import kotlinx.android.synthetic.main.activity_settings_dialog.*

class SettingsDialog(context: Context) : Dialog(context), SettingsView{
    lateinit var presenter: SettingsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SettingsPresenter(SharedPreferencesHelper(context),this)
        setContentView(R.layout.activity_settings_dialog)
        if (switch1.isChecked){
            if (presenter.isPasswordSet()){
                Toast.makeText(context, "Сначала задайте пароль", Toast.LENGTH_SHORT).show()
            }
            else{
                presenter.setLocked(true)
            }
        }
        else{
            presenter.setLocked(false)
        }
    }
}
