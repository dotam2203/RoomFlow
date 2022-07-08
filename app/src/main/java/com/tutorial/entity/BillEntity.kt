package com.demo.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  13/06/2022
 */
@Entity(tableName = "BILL")
@Parcelize
data class BillEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID_BILL") val idBill: Int,
    @ColumnInfo(name = "DATE") val date: String,
    @ColumnInfo(name = "MONEY") val money: String?,
    @ColumnInfo(name = "PRODUCTS") val products: Int,
    @ColumnInfo(name = "ID_STAFF") val idStaff: String,
) : Parcelable
