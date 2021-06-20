package com.sklinn.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T,VH:RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    protected val itemList = mutableListOf<T>()

    override fun getItemCount(): Int {
        return itemList.size
    }

    protected fun getLayoutInflator(view: ViewGroup) = LayoutInflater.from(view.context)

    fun setNewData(newItems: List<T>){
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): T {
        return itemList[position]
    }
}