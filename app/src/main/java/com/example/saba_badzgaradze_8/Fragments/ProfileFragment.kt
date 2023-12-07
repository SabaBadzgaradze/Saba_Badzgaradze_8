package com.example.saba_badzgaradze_8.Fragments

import android.database.Cursor
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.saba_badzgaradze_8.Adapter.MyRecyclerViewAdapter
import com.example.saba_badzgaradze_8.DataList
import com.example.saba_badzgaradze_8.R
import com.example.saba_badzgaradze_8.SQLiteHelper

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private lateinit var recyclerView: RecyclerView
    lateinit var dbh: SQLiteHelper
    private lateinit var newArray: ArrayList<DataList>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)

        dbh = SQLiteHelper(activity)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        displayUser()

    }

    private fun displayUser(){
        var newCursor: Cursor? = dbh!!.getText()
        newArray = ArrayList<DataList>()
        while (newCursor!!.moveToNext()){
            val uname = newCursor.getString(0)
            val unumber = newCursor.getString(1)
            newArray.add(DataList(uname,unumber))
        }
        recyclerView.adapter = MyRecyclerViewAdapter(newArray)
    }

}