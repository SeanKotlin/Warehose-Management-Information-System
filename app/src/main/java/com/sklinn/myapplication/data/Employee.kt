package com.sklinn.myapplication.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    @ColumnInfo(name = "employee_name")
    val name: String,
    val email: String,
    val jobTitle: String?,
    val assignedTownship: String,
    val assignedState: String,
    val businessPhone: String,
    val mobilePhone: String,
    val address: String,
    val notes: String,
) : Parcelable {
}