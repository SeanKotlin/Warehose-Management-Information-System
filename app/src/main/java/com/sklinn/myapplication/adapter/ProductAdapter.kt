package com.sklinn.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.data.Product

class ProductAdapter(): RecyclerView.Adapter<ProductAdapter.myViewHolder>() {

    private var productList = emptyList<Product>()

    inner class myViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(null,parent,false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = productList[position]

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setNewData(products: List<Product>){
        this.productList = products
        notifyDataSetChanged()
    }
}