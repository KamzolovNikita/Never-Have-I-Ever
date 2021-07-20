package com.example.nhie.store

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.nhie.R
import java.util.*

@BindingAdapter("priceItemFormatted")
fun TextView.setPriceItemFormatted(item: StoreItem) {
    val locale = Locale.getDefault()
    val currency = Currency.getInstance(locale)
    text = resources.getString(
        R.string.store_game_price,
        String.format("%.2f", item.price),
        currency.symbol
    )
}

@BindingAdapter("nameItemString")
fun TextView.setNameItemString(item: StoreItem) {
    text = resources.getString(item.name)
}

@BindingAdapter("newQuestionsCounterString")
fun TextView.setNewQuestionsCounterString(item: StoreItem) {
    text = resources.getString(item.questions)
}

@BindingAdapter("itemImage")
fun ImageView.setItemImage(item: StoreItem) {
    setImageResource(item.image)
}