package com.example.fintrack.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryUiData(
    val nameCategory: String,
    @DrawableRes val colorCategory: Int,
    @DrawableRes val iconCategory: Int,
    val isSelect: Boolean
): Parcelable
