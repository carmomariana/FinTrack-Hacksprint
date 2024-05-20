package com.example.fintrack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.fintrack.data.db.entity.ExpenseEntity
import com.example.fintrack.data.model.Expense
import com.example.fintrack.data.model.ExpenseCategory

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM EXPENSE_TABLE")
    suspend fun getAllExpense(): List<Expense>

    @Insert(onConflict = IGNORE)
    suspend fun insertExpense(expenseEntity: ExpenseEntity): Long

    @Query("DELETE FROM EXPENSE_TABLE WHERE id = :id")
    suspend fun deleteExpense(id: Long)

    @Query(
        "UPDATE EXPENSE_TABLE SET nameExpense = :nameExpense, category = :category," +
                "price = :price, amount = :amount WHERE id = :id"
    )
    suspend fun updateExpense(
        id: Long,
        nameExpense: String,
        category: ExpenseCategory,
        price: Double,
        amount: Double,
    )
}