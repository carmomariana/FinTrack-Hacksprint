package com.example.fintrack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fintrack.data.db.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Query("SELECT * From category_table")
    suspend fun getAllCategory(): List<CategoryEntity>

    @Insert
   suspend fun insertAll(vararg categoryEntity: List<CategoryEntity>)
}