package com.example.fintrack.data.model

data class Expense(

    var id: String = "",
    var nameExpense: String = "",
    var category: ExpenseCategory,
    var price: Double,
    var amount: Double,
)
