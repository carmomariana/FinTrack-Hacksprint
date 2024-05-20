package com.example.fintrack.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fintrack.data.model.ExpenseCategory

@Entity(tableName = "expense_table")
class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nameExpense: String,
    val category: ExpenseCategory,
    val price: Double,
    val amount: Double,
)