package com.tutorial.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.entity.AccountEntity
import com.tutorial.dao.AccountDao

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  13/06/2022
 */
@Database(entities = [AccountEntity::class], version = 1, exportSchema = false)
abstract class AccountDB: RoomDatabase(){
    abstract fun accDao(): AccountDao

    companion object{
        @Volatile
        //singleton
        private var INSTANCE: AccountDB? = null
        fun getDatabase(context: Context): AccountDB{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccountDB::class.java,
                    "StaffManager"
                ).build()
                INSTANCE = instance
//                return instance
                instance
            }
        }
    }
}