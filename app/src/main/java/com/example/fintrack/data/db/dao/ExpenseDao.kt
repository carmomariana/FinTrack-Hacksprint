package com.example.fintrack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.fintrack.data.db.entity.ExpenseEntity
import com.example.fintrack.data.model.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM EXPENSE_TABLE")
    suspend fun getAllExpense(): List<Expense>

    @Insert(onConflict = IGNORE)
    suspend fun insertExpense(expenseEntity: ExpenseEntity): Long

    @Query("DELETE FROM EXPENSE_TABLE WHERE id = :id")
    suspend fun deleteExpense(id: Long)

    @Query(
        "UPDATE EXPENSE_TABLE SET nameExpense = :nameExpense, imageColor = :imageColor, category = :category," +
                "iconExpense = :iconExpense,price = :price, amount = :amount WHERE id = :id"
    )
    suspend fun updateExpense(
        id: Long,
        imageColor: Int,
        nameExpense: String,
        category: String,
        iconExpense: Int,
        price: Double,
        amount: Double,
    )
}