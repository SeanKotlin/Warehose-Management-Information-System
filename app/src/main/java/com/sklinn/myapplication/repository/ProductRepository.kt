package com.sklinn.myapplication.repository

import com.sklinn.myapplication.data.Product
import com.sklinn.myapplication.data.ProductDao

class ProductRepository(
    private val productDao: ProductDao
) {
    val readAllProduct = productDao.readAllProduct()

    suspend fun addProduct(product: Product){
        productDao.addProduct(product)
    }

    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDao.deleteProduct(product)
    }

    suspend fun deleteAllProduct(){
        productDao.deleteAllProduct()
    }
}