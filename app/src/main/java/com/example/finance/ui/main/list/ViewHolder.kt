package com.example.finance.ui.main.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.finance.R
import com.example.finance.data.ContactModel

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.contactName)
    var amount: TextView = itemView.findViewById(R.id.contactAmount)
    var comment: TextView = itemView.findViewById(R.id.commentId1)
    fun populateModel(model: ContactModel){
        name.text = model.name
        amount.text = model.amount.toString()
        if(model.comment.isNullOrEmpty()) {
            comment.visibility = View.GONE
        } else {
            comment.visibility = View.VISIBLE
        }
        comment.text = model.comment
    }
}