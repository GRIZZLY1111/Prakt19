package com.dignerdranch.anroid.prakt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data class Book(var title: String, val authors: List<String>,
        var isbn: String, var pageCount: Int,var isFiction: Boolean)
        val book: Book = Gson().fromJson(toString(), Book.class)
    }
}