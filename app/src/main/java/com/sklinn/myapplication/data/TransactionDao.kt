package com.sklinn.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TransactionDao {

    @Insert
    suspend fun addTransaction(transaction: Transaction)

    @Query("SELECT * FROM table_transaction")
    fun readAllTransaction(): LiveData<List<Transaction>>

    @Update
    suspend fun updateTransation(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("DELETE FROM table_transaction")
    suspend fun deleteAllTransaction(): LiveData<List<Transaction>>
}