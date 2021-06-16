package com.sklinn.myapplication.repository

import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.EmployeeDao
import com.sklinn.myapplication.data.Transaction
import com.sklinn.myapplication.data.TransactionDao

class TransactionRepository(
    private val transactionDao: TransactionDao
) {
    val readAllTransaction = transactionDao.readAllTransaction()

    suspend fun addEmployee(transaction: Transaction){
        transactionDao.addTransaction(transaction)
    }

    suspend fun updateEmployee(transaction: Transaction){
        transactionDao.updateTransation(transaction)
    }

    suspend fun deleteEmployee(transaction: Transaction){
        transactionDao.deleteTransaction(transaction)
    }

    suspend fun deleteAllEmployee(){
        transactionDao.deleteAllTransaction()
    }
}