package com.example.nhie.preview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GamePreviewViewModel : ViewModel() {
    private val _eventGameNavigate = MutableLiveData<Boolean>()
    val eventGameNavigate: LiveData<Boolean>
        get() = _eventGameNavigate

    private val _eventBackNavigate = MutableLiveData<Boolean>()
    val eventBackNavigate: LiveData<Boolean>
        get() = _eventBackNavigate

    fun onBackNavigate() {
        _eventBackNavigate.value = true
    }

    fun onGameNavigate() {
        _eventGameNavigate.value = true
    }

    fun onNavigateFinish() {
        _eventGameNavigate.value = false
    }
}