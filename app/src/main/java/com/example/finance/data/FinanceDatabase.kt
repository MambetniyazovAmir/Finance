package com.example.finance.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [ContactModel::class], version = 2, exportSchema = false)
abstract class FinanceDatabase: RoomDatabase() {

    abstract fun financeDao(): FinanceDao

    companion object {
        private var INSTANCE: FinanceDatabase? = null

        fun getInstance(context: Context):FinanceDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,FinanceDatabase::class.java, "finance.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}