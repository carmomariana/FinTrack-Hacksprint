package com.example.fintrack.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fintrack.data.model.Expense

@Entity(tableName = "expense_table")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imageColor: Int,
    val category: String,
    val nameExpense: String,
    val iconExpense: Int,
    val price: Double,
    val amount: Double = 0.0,
)
