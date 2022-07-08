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
//@Entity(tableName = "STAFF", indices = [Index(value = ["EMAIL"], unique = true)])
@Entity(tableName = "STAFF")
@Parcelize
data class StaffEntity(
    @PrimaryKey @ColumnInfo(name = "ID_STAFF") val idStaff: String,
    @ColumnInfo(name = "FULL_NAME") val fullName: String,
    @ColumnInfo(name = "PHONE") val phone: String?,
    @ColumnInfo(name = "EMAIL") val email: String
) : Parcelable
