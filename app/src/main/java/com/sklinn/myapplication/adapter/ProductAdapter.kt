package com.sklinn.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Product
import kotlinx.android.synthetic.main.item_products.view.*

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.myViewHolder>() {

    private var productList = mutableListOf<Product>()

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_products,parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = productList[position]
        holder.itemView.apply {
            tvItem.text = data.item
            tvLotNumber.text = data.lotNumber
            tvExpiryDate.text = data.expiryDate
        }
    }

    fun setNewData(products: List<Product>){
        productList.clear()
        productList.addAll(products)
        notifyDataSetChanged()
    }
}