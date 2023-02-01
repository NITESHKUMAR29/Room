package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.room.dao.QuoteDao
import com.example.room.databases.QuoteDataBase
import com.example.room.databinding.ActivityMainBinding
import com.example.room.models.QuoteModel
import com.example.room.repositories.QuotRepository
import com.example.room.viewModels.MainVieModels
import com.example.room.viewModels.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainVieModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao=QuoteDataBase.getDataBase(this).quoteDao()
        val quotRepository=QuotRepository(dao)
        viewModel= ViewModelProvider(this,MainViewModelFactory(quotRepository))[MainVieModels::class.java]
        val data=viewModel.getData().observe(this){
            Log.d("n/kdata",it.toString())
        }

        with(binding){
            text.setOnClickListener {
            lifecycleScope.launch {
                viewModel.insertData(QuoteModel(0,"nitesh kumar","nitesh"))
            }
            }
        }
    }
}