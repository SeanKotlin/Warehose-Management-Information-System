package com.sklinn.myapplication.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_vendor")
class Vendor(
    @PrimaryKey(autoGenerate = true)
    val vendorId: Long? = null,
    @ColumnInfo(name = "vendor_name")
    val vendorName: String,
    @ColumnInfo(name = "vendor_contactPerson")
    val contactPerson: String,
    val email: String,
    val businessPhone: String,
    val mobilePhone: String,
    val address: String,
    val notes: String,
) : Parcelable