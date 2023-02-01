package com.example.room.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.room.models.QuoteModel
import com.example.room.repositories.QuotRepository

class MainVieModels(private val  quoteRepository: QuotRepository):ViewModel() {

    private val insertData=MutableLiveData<List<QuoteModel>>()

    val data:LiveData<List<QuoteModel>>
    get() = insertData

    suspend fun insertData(quoteModel: QuoteModel){
        quoteRepository.insertData(quoteModel)
    }
    @JvmName("getData1")
    fun getData():LiveData<List<QuoteModel>>{
        return quoteRepository.getData()
    }
}