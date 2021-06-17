package com.sklinn.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(
    application: Application
) : AndroidViewModel(application) {

    val readAllEmployee: LiveData<List<Employee>>
    private val employeeRepository: EmployeeRepository


    init {
        val employeeDao = AppDatabase.getDatabase(application).employeeDao()
        employeeRepository = EmployeeRepository(employeeDao)
        readAllEmployee = employeeDao.readALlEmployee()
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
}