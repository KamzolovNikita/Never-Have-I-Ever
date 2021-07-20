package com.example.nhie.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nhie.util.GameUICharacteristic

class GameViewModel(val gameUI: GameUICharacteristic) : ViewModel() {
    private val _eventBackNavigate = MutableLiveData<Boolean>()
    val eventBackNavigate: LiveData<Boolean>
        get() = _eventBackNavigate

    fun onBackNavigate() {
        _eventBackNavigate.value = true
    }

    fun onNavigateFinish() {
        _eventBackNavigate.value = false
    }

    private val _eventNextButtonPressed = MutableLiveData<Boolean>()
    val eventNextButtonPressed: LiveData<Boolean>
        get() = _eventNextButtonPressed

    private fun onNextButtonPressed() {
        _eventNextButtonPressed.value = true
    }

    fun onNextButtonPressedComplete() {
        _eventNextButtonPressed.value = false
    }

    private val _eventRestartTextPressed = MutableLiveData<Boolean>()
    val eventRestartTextPressed: LiveData<Boolean>
        get() = _eventRestartTextPressed

    private fun onRestartTextPressed() {
        _eventRestartTextPressed.value = true
    }

    fun onRestartTextPressedComplete() {
        _eventRestartTextPressed.value = false
    }


    val maxQuestion = gameUI.listOfQuestion.size

    private val _curQuestionCounter = MutableLiveData<Int>()
    val curQuestionCounter: LiveData<Int>
        get() = _curQuestionCounter

    private val _curQuestionFrame = MutableLiveData<Int>()
    val curQuestionFrame: LiveData<Int>
        get() = _curQuestionFrame

    private val _curQuestionImage = MutableLiveData<Int>()
    val curQuestionImage: LiveData<Int>
        get() = _curQuestionImage

    private val _curNextQuestionButton = MutableLiveData<Int>()
    val curNextQuestionButton: LiveData<Int>
        get() = _curNextQuestionButton

    private val _curQuestionText = MutableLiveData<String>()
    val curQuestionText: LiveData<String>
        get() = _curQuestionText

    private val _curQuestionTextColor = MutableLiveData<Int>()
    val curQuestionTextColor: LiveData<Int>
        get() = _curQuestionTextColor


    private val _isNoMoreQuestions = MutableLiveData<Boolean>()
    val isNoMoreQuestions: LiveData<Boolean>
        get() = _isNoMoreQuestions



    init {
        firstQuestion()
    }

    private fun firstQuestion() {
        _isNoMoreQuestions.value = false
        _curQuestionCounter.value = 1
        _curQuestionFrame.value = gameUI.listOfQuestion[0].questionFrame
        _curQuestionImage.value = gameUI.listOfQuestion[0].image
        _curNextQuestionButton.value = gameUI.listOfQuestion[0].nextQuestionButton
        _curQuestionText.value = gameUI.listOfQuestion[0].questionText
        _curQuestionTextColor.value = gameUI.listOfQuestion[0].questionTextColor
    }


    fun nextQuestion() {
        onNextButtonPressed()
        _curQuestionCounter.value?.let {
            if (it < maxQuestion) {
                _curQuestionFrame.value = gameUI.listOfQuestion[it].questionFrame
                _curQuestionImage.value = gameUI.listOfQuestion[it].image
                _curNextQuestionButton.value = gameUI.listOfQuestion[it].nextQuestionButton
                _curQuestionText.value = gameUI.listOfQuestion[it].questionText
                _curQuestionTextColor.value = gameUI.listOfQuestion[it].questionTextColor
                _curQuestionCounter.value = it + 1
            }
            if(it == maxQuestion - 1) _isNoMoreQuestions.value = true
        }

    }

    fun restartGame() {
        onRestartTextPressed()
        gameUI.listOfQuestion.shuffle()
        firstQuestion()
    }
}