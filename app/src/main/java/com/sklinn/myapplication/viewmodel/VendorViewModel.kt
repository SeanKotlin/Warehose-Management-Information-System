package com.sklinn.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.Vendor
import com.sklinn.myapplication.data.VendorDao
import com.sklinn.myapplication.repository.EmployeeRepository
import com.sklinn.myapplication.repository.VendorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VendorViewModel(
    application: Application
) : AndroidViewModel(application) {

    val readAllVendor: LiveData<List<Vendor>>
    val vendorNameList: LiveData<List<String>>
    private val vendorRepository: VendorRepository


    init {
        val vendorDao = AppDatabase.getDatabase(application).vendorDao()
        vendorRepository = VendorRepository(vendorDao)
        readAllVendor = vendorDao.readAllVendors()
        vendorNameList = vendorDao.vendorNameList()
    }

    //Employee table
    fun addVendor(vendor: Vendor) {
        viewModelScope.launch(Dispatchers.IO) {
            vendorRepository.addVendor(vendor)
        }
    }

    fun updateVendor(vendor: Vendor) {
        viewModelScope.launch(Dispatchers.IO) {
            vendorRepository.updateVendor(vendor)
        }
    }

    fun deleteVendor(vendor: Vendor) {
        viewModelScope.launch(Dispatchers.IO) {
            vendorRepository.deleteVendor(vendor)
        }
    }

    fun deleteAllVendors() {
        viewModelScope.launch(Dispatchers.IO) {
            vendorRepository.deleteAllVendors()
        }
    }
}