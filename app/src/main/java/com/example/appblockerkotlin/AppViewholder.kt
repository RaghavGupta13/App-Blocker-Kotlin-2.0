package com.example.appblockerkotlin

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


//ViewHolder Class for the Recycler View
class AppViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val app_name: TextView = itemView.findViewById(R.id.id_single_item_app_text)
    val app_package: TextView = itemView.findViewById(R.id.id_single_item_app_package)
    val checkBox: CheckBox? = itemView.findViewById(R.id.id_checkbox)
}


