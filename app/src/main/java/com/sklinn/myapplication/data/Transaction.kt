package com.sklinn.myapplication.data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "table_transaction")
class Transaction (
    val transactionId: Long? = null,
    val transactionItem: String,
    val employeeName: String,
    val transactionType: Int,
    val quantity: Int,
    val createdDate: Date,
    val poNumber: String,
    val comment: String,
): Parcelable