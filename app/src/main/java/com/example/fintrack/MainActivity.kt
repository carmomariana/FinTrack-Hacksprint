package com.example.fintrack

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.data.model.Expense
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val rvExpense = findViewById<RecyclerView>(R.id.rv_expense)
    val button = findViewById<FloatingActionButton>(R.id.button_add)
    val adapter = AdapterExpense()

    rvExpense.adapter = adapter
    rvExpense.layoutManager = LinearLayoutManager(this)
    }
}