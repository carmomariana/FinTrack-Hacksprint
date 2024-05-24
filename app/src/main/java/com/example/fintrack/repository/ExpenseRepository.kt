package com.example.fintrack.repository

import com.example.fintrack.data.db.dao.ExpenseDao
import com.example.fintrack.data.db.entity.ExpenseEntity
import com.example.fintrack.data.model.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    suspend fun getAllExpense(): List<Expense> {
        return expenseDao.getAllExpense()
    }

    suspend fun insertExpense(expenseEntity: ExpenseEntity): Long {
        return expenseDao.insertExpense(expenseEntity)
    }

    suspend fun deleteExpense(id: Long) {
        return expenseDao.deleteExpense(id)
    }

    suspend fun updateExpense(expenseEntity: ExpenseEntity) {
        expenseDao.updateExpense(
            id = expenseEntity.id,
            imageColor = expenseEntity.imageColor,
            category = expenseEntity.category,
            nameExpense = expenseEntity.nameExpense,
            iconExpense = expenseEntity.iconExpense,
            price = expenseEntity.price,
            amount = expenseEntity.amount
        )
    }
}