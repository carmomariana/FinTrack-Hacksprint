package com.example.fintrack.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fintrack.data.model.ColorCategory
import com.example.fintrack.data.model.ExpenseCategory

@Entity(tableName = "category_table")
class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nameCategory: String = "",
    val colorCategory: ColorCategory,
    val iconCategory: ExpenseCategory
)