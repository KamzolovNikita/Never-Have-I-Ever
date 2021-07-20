package com.example.nhie.preview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nhie.util.GameUICharacteristic

class GamePreviewViewModelFactory(
        private val gameUI: GameUICharacteristic) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GamePreviewViewModel::class.java)) {
            return GamePreviewViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}