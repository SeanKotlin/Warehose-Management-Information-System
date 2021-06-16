package com.sklinn.myapplication.repository

import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.EmployeeDao

class employeeRepository(
    private val employeeDao: EmployeeDao
) {
    val readAllEmployee = employeeDao.readALlEmployee()

    suspend fun addEmployee(employee: Employee){
        employeeDao.addEmployee(employee)
    }

    suspend fun updateEmployee(employee: Employee){
        employeeDao.updateEmployee(employee)
    }

    suspend fun deleteEmployee(employee: Employee){
        employeeDao.deleteEmployee(employee)
    }

    suspend fun deleteAllEmployee(){
        employeeDao.deleteAllEmployee()
    }
}