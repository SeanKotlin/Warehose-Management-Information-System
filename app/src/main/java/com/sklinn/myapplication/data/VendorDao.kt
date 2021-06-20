package com.sklinn.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VendorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addVendor(vendor: Vendor)

    @Query("SELECT * FROM table_vendor")
    fun readAllVendors():LiveData<List<Vendor>>

    @Update
    suspend fun updateVendor(vendor: Vendor)

    @Delete
    suspend fun deleteVendor(vendor: Vendor)

    @Query("DELETE FROM table_vendor")
    suspend fun deleteAllVendors()

    @Query("SELECT vendor_name FROM table_vendor")
    fun vendorNameList(): LiveData<List<String>>
}