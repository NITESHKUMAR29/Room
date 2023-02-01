package com.example.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room.models.QuoteModel

@Dao
interface QuoteDao {

    @Query("SELECT * from quote")
    fun getData():LiveData<List<QuoteModel>>

    @Insert
    suspend fun insertData(quoteModel: QuoteModel)
}