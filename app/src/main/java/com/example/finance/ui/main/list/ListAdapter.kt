package com.example.finance.ui.main.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finance.R
import com.example.finance.data.ContactModel

class ListAdapter : RecyclerView.Adapter<ContactItemViewHolder>() {

    private var models: List<ContactModel> = arrayListOf()
    lateinit var listener: OnContactItemClickListener

    fun setData(models: List<ContactModel>){
        this.models = models
        notifyDataSetChanged()
    }

    fun setOnContactItemClickListener(listener: OnContactItemClickListener){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int){
        holder.populateModel(models[position],listener)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ContactItemViewHolder(view)
    }
}