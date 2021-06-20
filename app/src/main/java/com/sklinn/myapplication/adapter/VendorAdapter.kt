package com.sklinn.myapplication.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.data.Vendor

class VendorAdapter: BaseAdapter<Vendor, VendorAdapter.myviewHolder>() {

    inner class myviewHolder(view:View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorAdapter.myviewHolder {
        val view = getLayoutInflator(parent).inflate(null,parent)
        return myviewHolder(view)
    }

    override fun onBindViewHolder(holder: VendorAdapter.myviewHolder, position: Int) {
        val item = itemList[position]
        holder.itemView.apply {
            //pupulate UI
        }
    }

}