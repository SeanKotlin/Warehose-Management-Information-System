package com.sklinn.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.Product
import com.sklinn.myapplication.data.Transaction
import com.sklinn.myapplication.repository.ProductRepository
import com.sklinn.myapplication.repository.TransactionRepository
import com.sklinn.myapplication.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class WarehouseViewModel(application: Application): AndroidViewModel(application) {

    val readAllEmployee : LiveData<List<Employee>>
    val readAllProduct: LiveData<List<Product>>
    val readAllTransaction: LiveData<List<Transaction>>
    val employeeRepository: EmployeeRepository
    val productRepository: ProductRepository
    val transactionRepository: TransactionRepository

    init {
        val employeeDao = AppDatabase.getDatabase(application).employeeDao()
        employeeRepository = EmployeeRepository(employeeDao)
        readAllEmployee = employeeRepository.readAllEmployee

        val productDao = AppDatabase.getDatabase(application).productDao()
        productRepository = ProductRepository(productDao)
        readAllProduct = productRepository.readAllProduct

        val transactionDao = AppDatabase.getDatabase(application).transactionDao()
        transactionRepository = TransactionRepository(transactionDao)
        readAllTransaction = transactionRepository.readAllTransaction
    }

    //Employee table
    fun addEmployee(employee: Employee){
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.addEmployee(employee)
        }
    }

    //todo = all other function declared previously
}