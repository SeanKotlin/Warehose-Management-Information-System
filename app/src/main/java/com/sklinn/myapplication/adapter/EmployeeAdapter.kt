package com.sklinn.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.Product

class EmployeeAdapter(): RecyclerView.Adapter<EmployeeAdapter.myViewHolder>() {

    private var employeeList = emptyList<Employee>()

    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(null,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = employeeList[position]

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun setNewData(employees: List<Employee>){
        this.employeeList = employees
        notifyDataSetChanged()
    }
}