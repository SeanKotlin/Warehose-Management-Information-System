package com.sklinn.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.Product
import com.sklinn.myapplication.data.Transaction
import com.sklinn.myapplication.repository.EmployeeRepository
import com.sklinn.myapplication.repository.ProductRepository
import com.sklinn.myapplication.repository.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WarehouseViewModel(application: Application) : AndroidViewModel(application) {

    var readAllEmployee: LiveData<List<Employee>>
    var readAllProduct: LiveData<List<Product>>
    var readAllTransaction: LiveData<List<Transaction>>
    private val employeeRepository: EmployeeRepository
    private val productRepository: ProductRepository
    private val transactionRepository: TransactionRepository

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
    fun addEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.addEmployee(employee)
        }
    }

    fun updateEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.updateEmployee(employee)
        }
    }

    fun deleteEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.deleteEmployee(employee)
        }
    }

    fun deleteAllEmployee() {
        viewModelScope.launch(Dispatchers.IO) {
            employeeRepository.deleteAllEmployee()
        }
    }

    //Product Table
    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.addProduct(product)
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.updateProduct(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.deleteProduct(product)
        }
    }

    fun deleteAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.deleteAllProduct()
        }
    }
}