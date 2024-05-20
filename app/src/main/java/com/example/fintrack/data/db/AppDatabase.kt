package com.example.fintrack.data.db

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fintrack.data.db.dao.CategoryDao
import com.example.fintrack.data.db.dao.ExpenseDao
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.db.entity.ExpenseEntity


@Database(entities = [CategoryEntity::class, ExpenseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun CategoryDao(): CategoryDao
    abstract fun ExpenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "category_database, expense_database")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}

