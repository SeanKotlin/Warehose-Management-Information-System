package com.sklinn.myapplication.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_employee")
data class Employee(
    val id: Long? = null,
    val name: String,
    val email: String,
    val jobTitle: String,
    val assignedTownship: String,
    val assignedState: String? = "Kachin",
    val businessPhone: String,
    val mobilePhone: String?,
    val address: String,
    val notes: String?,
) : Parcelable {
}