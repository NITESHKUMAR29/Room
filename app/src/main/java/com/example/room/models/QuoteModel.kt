package com.example.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class QuoteModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val text:String,
    val author:String
)
