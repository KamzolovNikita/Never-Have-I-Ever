package com.example.nhie.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _eventFirstGameNavigate = MutableLiveData<Boolean>()
    val eventFirstGameNavigate: LiveData<Boolean>
        get() = _eventFirstGameNavigate

    fun onFirstGameNavigate() {
        _eventFirstGameNavigate.value = true
    }

    private val _eventSecondGameNavigate = MutableLiveData<Boolean>()
    val eventSecondGameNavigate: LiveData<Boolean>
        get() = _eventSecondGameNavigate

    fun onSecondGameNavigate() {
        _eventSecondGameNavigate.value = true
    }

    private val _eventNYGameNavigate = MutableLiveData<Boolean>()
    val eventNYGameNavigate: LiveData<Boolean>
        get() = _eventNYGameNavigate

    fun onNYGameNavigate() {
        _eventNYGameNavigate.value = true
    }

    private val _eventStoreNavigate = MutableLiveData<Boolean>()
    val eventStoreNavigate: LiveData<Boolean>
        get() = _eventStoreNavigate

    fun onStoreNavigate() {
        _eventStoreNavigate.value = true
    }

    private val _eventRulesNavigate = MutableLiveData<Boolean>()
    val eventRulesNavigate: LiveData<Boolean>
        get() = _eventRulesNavigate

    fun onRulesNavigate() {
        _eventRulesNavigate.value = true
    }

    fun onNavigateFinish() {
        _eventFirstGameNavigate.value = false
        _eventSecondGameNavigate.value = false
        _eventNYGameNavigate.postValue(false)
        _eventStoreNavigate.value = false
        _eventRulesNavigate.value = false
    }
}