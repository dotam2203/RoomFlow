package com.demo.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


/**
 * Author: tamdt35@fpt.com.vn
 * Date:  12/06/2022
 */
@Entity(tableName = "ACCOUNT")
@Parcelize
data class AccountEntity(
    @PrimaryKey @ColumnInfo(name = "EMAIL") var email: String = "",
    @ColumnInfo(name = "PASSWORD") var password: String = "",
    @ColumnInfo(name = "ROLE") var role: String = "",
) : Parcelable

