package com.example.fintrack.data.db

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fintrack.data.db.dao.CategoryDao
import com.example.fintrack.data.db.dao.ExpenseDao
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.db.entity.ExpenseEntity


@Database(entities = [ExpenseEntity::class, CategoryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun ExpenseDao(): ExpenseDao
    abstract fun CategoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "expense_database, category_table")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}

