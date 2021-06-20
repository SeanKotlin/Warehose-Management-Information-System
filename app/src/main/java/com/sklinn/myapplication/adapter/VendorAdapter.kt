package com.sklinn.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.Vendor
import kotlinx.android.synthetic.main.item_employee.view.*
import kotlinx.android.synthetic.main.item_vendors.view.*

class VendorAdapter() : RecyclerView.Adapter<VendorAdapter.myViewHolder>() {

    private var vendorList = mutableListOf<Vendor>()

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = vendorList[position]
        holder.itemView.apply {
            tv_VendorName.text = data.vendorName
            tv_contactPerson.text = data.contactPerson
            tv_BusinessPhone.text = data.businessPhone
        }
    }

    override fun getItemCount(): Int {
        return vendorList.size
    }

    fun setNewData(vendors: List<Vendor>) {
        vendorList.clear()
        vendorList.addAll(vendors)
        notifyDataSetChanged()
    }
}

