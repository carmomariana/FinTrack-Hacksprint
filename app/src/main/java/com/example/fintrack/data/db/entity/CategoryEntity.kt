package com.example.fintrack.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("key")
    val nameCategory: String,
    @ColumnInfo("color")
    val colorCategory: Int,
    @ColumnInfo("icon")
    val iconCategory: Int,
    @ColumnInfo("is_select")
    val isSelect: Boolean
)
