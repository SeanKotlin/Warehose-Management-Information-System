package com.sklinn.myapplication.repository

import com.sklinn.myapplication.data.Vendor
import com.sklinn.myapplication.data.VendorDao

class VendorRepository(
    private val vendorDao: VendorDao
) {
    val readAllVendor = vendorDao.readAllVendors()
    val employeeNameList = vendorDao.vendorNameList()

    suspend fun addVendor(vendor: Vendor){
        vendorDao.addVendor(vendor)
    }

    suspend fun updateVendor(vendor: Vendor){
        vendorDao.updateVendor(vendor)
    }

    suspend fun deleteVendor(vendor: Vendor){
        vendorDao.deleteVendor(vendor)
    }

    suspend fun deleteAllVendors(){
        vendorDao.deleteAllVendors()
    }

}