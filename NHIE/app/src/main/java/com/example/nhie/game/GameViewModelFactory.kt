package com.example.nhie.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nhie.util.GameUICharacteristic


class GameViewModelFactory(
        private val gameUI: GameUICharacteristic
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(gameUI) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}