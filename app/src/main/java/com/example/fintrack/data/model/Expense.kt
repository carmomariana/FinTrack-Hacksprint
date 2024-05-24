package com.example.fintrack.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Expense(
    var id: Long = 0,
    @DrawableRes var imageColor: Int,
    var category: String,
    var nameExpense: String = "",
    @DrawableRes var iconExpense: Int,
    var price: Double,
    var amount: Double = 0.0,
) : Parcelable
