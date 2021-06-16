package com.sklinn.myapplication.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "table_product")
data class Product(
    val productId: Long? =  null,
    val pCode: String,
    val item: String,
    val description: String,
    val category: String,
    val grants: String,
    val expiryDate: Date,
    val lotNumber: String,
    val countingUnit: String,
    val discontinued: Boolean,
    val comments: String
) : Parcelable {
}