package com.sklinn.myapplication.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Employee
import kotlinx.android.synthetic.main.item_employee.view.*

class EmployeeAdapter(): BaseAdapter<Employee,EmployeeAdapter.myViewHolder>() {

    private var employeeList = mutableListOf<Employee>()

    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = getLayoutInflator(parent).inflate(R.layout.item_employee, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = employeeList[position]
        holder.itemView.apply {
            tvcustomerName.text = data.name
            tvJobTitle.text = data.jobTitle
            tvPhone.text = data.businessPhone
        }
    }
}