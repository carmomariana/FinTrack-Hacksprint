package com.example.fintrack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.model.Category
import com.example.fintrack.data.model.ColorCategory
import com.example.fintrack.data.model.ExpenseCategory
@Dao
interface CategoryDao {

    @Query("SELECT * FROM CATEGORY_TABLE")
    suspend fun getAllCategory(): List<Category>

    @Insert(onConflict = IGNORE)
    suspend fun insertCategory(categoryEntity: CategoryEntity): Long

    @Query("DELETE FROM category_table WHERE id = :id")
    suspend fun deleteCategory(id: Long)

    @Query("UPDATE CATEGORY_TABLE SET nameCategory = :nameCategory, colorCategory = :colorCategory, iconCategory = :iconCategory WHERE id = :id")
    suspend fun updateCategory(
        id: Long,
        nameCategory: String,
        colorCategory: ColorCategory,
        iconCategory: ExpenseCategory
    )
}