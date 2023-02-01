package com.example.room.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.repositories.QuotRepository


class MainViewModelFactory(private val quotRepository: QuotRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return MainVieModels(quotRepository) as T


    }
}