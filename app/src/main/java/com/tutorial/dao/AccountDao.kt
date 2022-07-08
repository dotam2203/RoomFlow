package com.tutorial.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.entity.AccountEntity
import kotlinx.coroutines.flow.Flow

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  13/06/2022
 */
@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAccount(acc: AccountEntity)

    @Query("SELECT *FROM ACCOUNT WHERE EMAIL = :email")
    suspend fun getAccountByEmail(email: String): AccountEntity?

    @Query("SELECT * FROM ACCOUNT ORDER BY EMAIL ASC")
    fun getAllAccount():  Flow<List<AccountEntity>>
}