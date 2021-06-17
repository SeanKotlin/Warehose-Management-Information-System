package com.sklinn.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEmployee(employee: Employee)

    @Query("SELECT * FROM table_employee")
    fun readALlEmployee(): LiveData<List<Employee>>

    @Update
    suspend fun updateEmployee(employee: Employee)

    @Delete
    suspend fun deleteEmployee(employee: Employee)

    @Query("DELETE FROM table_employee")
    suspend fun deleteAllEmployee()
}