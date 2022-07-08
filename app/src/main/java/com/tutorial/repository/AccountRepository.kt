package com.tutorial.repository

import com.demo.entity.AccountEntity
import com.tutorial.dao.AccountDao
import kotlinx.coroutines.flow.Flow

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  14/06/2022
 */
class AccountRepository(val accDao: AccountDao) {
    suspend fun addAccount(accEntity: AccountEntity){
        accDao.addAccount(accEntity)
    }
    suspend fun getAccountByEmail(email: String): AccountEntity? = accDao.getAccountByEmail(email)
    val getAllAccount: Flow<List<AccountEntity>> = accDao.getAllAccount()
}