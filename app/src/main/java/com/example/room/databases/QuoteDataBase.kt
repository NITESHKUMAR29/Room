package com.example.room.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.dao.QuoteDao
import com.example.room.models.QuoteModel

@Database(entities = [QuoteModel::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuoteDataBase? = null
        fun getDataBase(context: Context): QuoteDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, QuoteDataBase::class.java, "quote_database")
                            .build()
                }

            }
            return INSTANCE!!
        }
    }
}