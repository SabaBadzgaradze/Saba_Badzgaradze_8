package com.example.saba_badzgaradze_8.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.saba_badzgaradze_8.DataList
import com.example.saba_badzgaradze_8.R

class MyRecyclerViewAdapter(var userList: ArrayList<DataList>): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tname: TextView = itemView.findViewById(R.id.textView)
        val tnumber: TextView = itemView.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tname.text = currentItem.name
        holder.tnumber.text = currentItem.contact
    }
}