package com.sklinn.myapplication.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Product
import kotlinx.android.synthetic.main.item_products.view.*

class ProductAdapter() : BaseAdapter<Product, ProductAdapter.myViewHolder>() {

    private var productList = mutableListOf<Product>()

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = getLayoutInflator(parent).inflate(R.layout.item_products, parent, false)
        return myViewHolder(view)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = productList[position]
        holder.itemView.apply {
            tvItem.text = data.item
            tvLotNumber.text = data.lotNumber
            tvExpiryDate.text = data.expiryDate
        }
    }
}