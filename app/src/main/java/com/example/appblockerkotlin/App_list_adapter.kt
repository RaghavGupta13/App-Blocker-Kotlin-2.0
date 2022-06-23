package com.example.appblockerkotlin

import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//Adapter for the Recycler View
class App_list_adapter(private val list: MutableList<ModelClass>, private val layout_id: Int):
    RecyclerView.Adapter<AppViewholder>() {

    lateinit var modelClass: ModelClass
    val blockedApps: MutableList<ModelClass> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewholder {
        val v: View =  LayoutInflater.from(parent.context).inflate(layout_id, parent, false)
        return AppViewholder(v)
    }

    override fun onBindViewHolder(holder: AppViewholder, position: Int) {
        val currentPostion: ModelClass = list.get(position)
        holder.app_name.text = currentPostion.app_name
        holder.app_package.text = currentPostion.app_package

        if(holder.checkBox != null){
            holder.checkBox.setOnClickListener(View.OnClickListener {
                if(holder.checkBox.isChecked){
                    modelClass = ModelClass(currentPostion.app_name, currentPostion.app_package)
                    blockedApps.add(modelClass)
                }
            })
        }
    }

    override fun getItemCount(): Int {
        if(list != null || list.size>0){
            return list.size
        }else{
            return 0
        }
    }

    fun getBlockedAppList(): MutableList<ModelClass>{
        return blockedApps
    }
}