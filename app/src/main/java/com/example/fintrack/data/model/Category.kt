package com.example.fintrack.data.model


data class Category(
    var id: String = "",
    var nameCategory: String = "",
    var colorCategory: ColorCategory,
    var iconCategory: ExpenseCategory
) {
    val icon = iconCategory.icon
    val color = colorCategory.color
}