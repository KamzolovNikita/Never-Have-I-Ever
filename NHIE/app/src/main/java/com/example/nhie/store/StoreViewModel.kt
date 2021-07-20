package com.example.nhie.store

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.SkuDetailsParams
import com.example.nhie.R

const val PREF_FILE = "PURCHASED_ITEMS"

class StoreViewModel : ViewModel() {

    private val _eventBackNavigate = MutableLiveData<Boolean>()
    val eventBackNavigate: LiveData<Boolean>
        get() = _eventBackNavigate

    fun onBackNavigate() {
        _eventBackNavigate.value = true
    }

    fun onNavigateFinish() {
        _eventBackNavigate.value = false
    }

    val storeItems: List<StoreItem> = listOf(
        StoreItem(
            R.string.first_game_name,
            99.0,
            R.string.store_first_game_new_questions,
            R.drawable.storescreen_nhie_logo,
            "aaa"
        ),
        StoreItem(
            R.string.second_game_name,
            179.0,
            R.string.store_second_game_new_questions,
            R.drawable.storescreen_nhie2_logo,
            "bbb"
        ),
        StoreItem(
            R.string.ny_game_name,
            99.0,
            R.string.store_ny_game_new_questions,
            R.drawable.storescreen_nhie_ny_logo,
            "ccc"
        )
    )



}