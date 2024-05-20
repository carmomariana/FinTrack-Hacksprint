package com.example.fintrack.repository

import com.example.fintrack.data.db.dao.ExpenseDao
import com.example.fintrack.data.db.entity.ExpenseEntity
import com.example.fintrack.data.model.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    suspend fun getAllCategory(): List<Expense> {
        return expenseDao.getAllExpense()
    }

    suspend fun insertCategory(expenseEntity: ExpenseEntity): Long {
        return expenseDao.insertExpense(expenseEntity)
    }

    suspend fun deleteCategory(id: Long) {
        return expenseDao.deleteExpense(id)
    }

    suspend fun updateCategory(expenseEntity: ExpenseEntity) {
        expenseDao.updateExpense(
            id = expenseEntity.id,
            nameExpense = expenseEntity.nameExpense,
            category = expenseEntity.category,
            price = expenseEntity.price,
            amount = expenseEntity.amount
        )
    }
}