package com.example.appblockerkotlin

import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllAppsActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: App_list_adapter
    lateinit var blockedApps: MutableList<ModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_apps)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        getAppNames()
        setAdaper()
    }


    //Method to get names of all the apps on the system
    private fun getAppNames(){
        val intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val resolveInfos: List<ResolveInfo> = packageManager.queryIntentActivities(intent, 0)
        val list: MutableList<ModelClass> = ArrayList()

        for(i in resolveInfos.indices){
            val app_name: String = resolveInfos[i].activityInfo.loadLabel(packageManager).toString()
            val app_package: String = resolveInfos[i].activityInfo.packageName

            val modelClass = ModelClass(app_name, app_package)
            list.add(i, modelClass)
        }

        adapter = App_list_adapter(list, R.layout.single_item_layout)
    }

    //Setup recycler view and adapter
    private fun setAdaper(){
        recyclerView = findViewById(R.id.id_recycler_view_all_apps)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    //Inflate the check button menu icon on the title bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        return true
    }

    //Handle the check button icon click on the title bar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.id_menu_ok){
            blockedApps = adapter.getBlockedAppList()

            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putParcelableArrayListExtra("blockedAppList", ArrayList(blockedApps))
            startActivity(intent)
            finish()
        }
        return true
    }
}