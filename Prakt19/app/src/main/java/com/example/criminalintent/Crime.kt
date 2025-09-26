package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.UUID
import java.util.Date

class Crime : AppCompatActivity() {
    data class Crime(
        val id: UUID = UUID.randomUUID(),
        var title: String = "",
        val  date: Date,
        var isSolved: Boolean = false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)
    }
}