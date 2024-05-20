package com.example.fintrack.repository

import com.example.fintrack.data.db.dao.CategoryDao
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.model.Category

class CategoryRepository(private val categoryDao: CategoryDao) {

    suspend fun getAllCategory(): List<Category> {
        return categoryDao.getAllCategory()
    }

    suspend fun insertCategory(categoryEntity: CategoryEntity): Long {
        return categoryDao.insertCategory(categoryEntity)
    }

    suspend fun deleteCategory(id: Long) {
        return categoryDao.deleteCategory(id)
    }

    suspend fun updateCategory(categoryEntity: CategoryEntity) {
        categoryDao.updateCategory(
            id = categoryEntity.id,
            nameCategory = categoryEntity.nameCategory,
            colorCategory = categoryEntity.colorCategory,
            iconCategory = categoryEntity.iconCategory
        )
    }
}