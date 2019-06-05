package com.example.finance.ui.main.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finance.R
import com.example.finance.data.ContactModel

class ListAdapter : RecyclerView.Adapter<ViewHolder>() {

    var models: List<ContactModel> = arrayListOf()

    fun setData(models: List<ContactModel>){
        this.models = models
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }
}