package com.example.room.repositories

import androidx.lifecycle.LiveData
import com.example.room.dao.QuoteDao
import com.example.room.models.QuoteModel

class QuotRepository(private val quoteDao: QuoteDao) {

    fun getData():LiveData<List<QuoteModel>>{
        return quoteDao.getData()
    }
    suspend fun insertData(quoteModel: QuoteModel){
        return quoteDao.insertData(quoteModel)
    }
}