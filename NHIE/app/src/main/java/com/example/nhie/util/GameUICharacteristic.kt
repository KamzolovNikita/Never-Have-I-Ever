package com.example.nhie.util

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class GameUICharacteristic(
        val listOfQuestion: MutableList<QuestionUI>,
        val gameLogo: Int,
        val previewImage: Int,
        val startGameButton: Int,
        val gameName: String
) : Parcelable

@Parcelize
data class QuestionUI (
        val questionFrame: Int,
        val nextQuestionButton: Int,
        val questionText: String,
        val questionTextColor: Int,
        val image: Int
) : Parcelable