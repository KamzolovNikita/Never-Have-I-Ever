package com.example.nhie.store

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StoreItem(
    @StringRes val name: Int,
    val price: Double,
    @StringRes val questions: Int,
    @DrawableRes val image: Int,
    val id: String
)
