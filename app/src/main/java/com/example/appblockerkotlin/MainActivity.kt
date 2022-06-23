package com.example.appblockerkotlin

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var fab: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: App_list_adapter
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showAllApps()
        getIntentList()
    }

    private fun showAllApps(){
        //handles the click event for the floating action button
        //will open a new activity which will contain the list of all the apps running on the system

        fab = findViewById(R.id.id_fab);

        fab.setOnClickListener(View.OnClickListener {
            Intent(this, AllAppsActivity::class.java).also {
                startActivity(it)
            }
        })
    }


    //Method for setting up the adapter
    private fun setAdapter(list: MutableList<ModelClass>){
        recyclerView = findViewById(R.id.id_recycler_view)
        adapter = App_list_adapter(list, R.layout.single_item_layout_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    //Method to display the blocked apps on the Main Activity page
    private fun getIntentList(){
        btn = findViewById(R.id.id_show_blocked_apps_btn)

        btn.setOnClickListener(View.OnClickListener {
             val arrayList: ArrayList<ModelClass> = this.intent.getParcelableArrayListExtra("blockedAppList")!!
                setAdapter(arrayList as MutableList<ModelClass>)

        })
    }

    //Method to detect blocked apps and display a Lock Activity if matched
    /*
    This method will be implemented from the ** PROTOTYPE APP ** where we will search for
    the top package name in the list that we got from 'getIntentList()' method.
    If there is a match, the Lock Activity will take over
     */

    private fun startBlockingApps(){}
}