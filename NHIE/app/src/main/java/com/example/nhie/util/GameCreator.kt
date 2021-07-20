package com.example.nhie.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.nhie.R


enum class GameType {
    FIRST, SECOND, NEW_YEAR
}

class GameCreator(private val gameType: GameType) {
    lateinit var context: Context

    fun gameInit(context: Context?) : GameUICharacteristic {
        if (context != null) {
            this.context = context.applicationContext
        }
        return when(gameType) {
            GameType.FIRST -> gameOneInit()
            GameType.SECOND -> gameTwoInit()
            GameType.NEW_YEAR -> gameNYInit()
        }
    }

   private fun gameOneInit() : GameUICharacteristic{
       val startGameButton = R.drawable.startgamebutton_nhie1
       val gameLogo = R.drawable.logo_nhie1
       val previewImage = R.drawable.questionimage_nhie1_light_1
       val gameName = context.getString(R.string.previewscreen_heading_nhie1)
       val listOfQuestion: MutableList<QuestionUI> = mutableListOf()
       val questionTextColorLight: Int = ContextCompat.getColor(context, R.color.main_game_one_light_blue)
       val questionTextColorHard: Int = ContextCompat.getColor(context, R.color.main_game_one_hard_orange)
       val questionFrameLight = R.drawable.questionframe_nhie1_light
       val questionFrameHard = R.drawable.questionframe_nhie1_hard
       val nextQuestionButtonLight = R.drawable.nextquestion_button_nhie1_light
       val nextQuestionButtonHard = R.drawable.nextquestion_button_nhie1_hard
       val listOfQuestionsLight =
               context.resources.getStringArray(R.array.questions_game_one_light).toMutableList()
       val listOfQuestionsHard =
               context.resources.getStringArray(R.array.questions_game_one_hard).toMutableList()
       for (i in 1..60) {
           listOfQuestion.add(QuestionUI(
                   questionFrameLight,
                   nextQuestionButtonLight,
                   listOfQuestionsLight[i-1],
                   questionTextColorLight,
                   context.resources.getIdentifier(
                           "questionimage_nhie1_light_$i",
                           "drawable",
                           context.packageName
                   )
           ))
           listOfQuestion.add(QuestionUI(
                   questionFrameHard,
                   nextQuestionButtonHard,
                   listOfQuestionsHard[i-1],
                   questionTextColorHard,
                   context.resources.getIdentifier(
                           "questionimage_nhie1_hard_$i",
                           "drawable",
                           context.packageName
                   )
           ))
       }
       listOfQuestion.shuffle()
       return GameUICharacteristic(listOfQuestion, gameLogo, previewImage, startGameButton, gameName)
   }



    private fun gameTwoInit() : GameUICharacteristic{
        val startGameButton = R.drawable.startgamebutton_nhie2
        val gameLogo = R.drawable.logo_nhie2
        val previewImage = R.drawable.questionimage_nhie2_light_1
        val gameName = context.getString(R.string.previewscreen_heading_nhie2)
        val listOfQuestion: MutableList<QuestionUI> = mutableListOf()
        val questionTextColorLight: Int = ContextCompat.getColor(context, R.color.main_game_two_light_green)
        val questionTextColorHard: Int = ContextCompat.getColor(context, R.color.main_game_two_hard_pink)
        val questionFrameLight = R.drawable.questionframe_nhie2_light
        val questionFrameHard = R.drawable.questionframe_nhie2_hard
        val nextQuestionButtonLight = R.drawable.nextquestion_button_nhie2_light
        val nextQuestionButtonHard = R.drawable.nextquestion_button_nhie2_hard
        val listOfQuestionsLight =
                context.resources.getStringArray(R.array.questions_game_two_light).toMutableList()
        val listOfQuestionsHard =
                context.resources.getStringArray(R.array.questions_game_two_hard).toMutableList()
        for (i in 1..60) {
            listOfQuestion.add(QuestionUI(
                    questionFrameLight,
                    nextQuestionButtonLight,
                    listOfQuestionsLight[i-1],
                    questionTextColorLight,
                    context.resources.getIdentifier(
                            "questionimage_nhie2_light_$i",
                            "drawable",
                            context.packageName
                    )
            ))
            listOfQuestion.add(QuestionUI(
                    questionFrameHard,
                    nextQuestionButtonHard,
                    listOfQuestionsHard[i-1],
                    questionTextColorHard,
                    context.resources.getIdentifier(
                            "questionimage_nhie2_hard_$i",
                            "drawable",
                            context.packageName
                    )
            ))
        }
        listOfQuestion.shuffle()
        return GameUICharacteristic(listOfQuestion, gameLogo, previewImage, startGameButton, gameName)
    }

    private fun gameNYInit() : GameUICharacteristic{
        val startGameButton = R.drawable.startgamebutton_nhie_ny
        val gameLogo = R.drawable.logo_nhie_ny
        val previewImage = R.drawable.questionimage_nhie_ny_light_1
        val gameName = context.getString(R.string.previewscreen_heading_nhie_ny)
        val listOfQuestion: MutableList<QuestionUI> = mutableListOf()
        val questionTextColorLight: Int = ContextCompat.getColor(context, R.color.main_game_ny_light_green)
        val questionTextColorHard: Int = ContextCompat.getColor(context, R.color.main_game_ny_hard_orange)
        val questionFrameLight = R.drawable.questionframe_nhie_ny_light
        val questionFrameHard = R.drawable.questionframe_nhie_ny_hard
        val nextQuestionButtonLight = R.drawable.nextquestion_button_nhie_ny_light
        val nextQuestionButtonHard = R.drawable.nextquestion_button_nhie_ny_hard
        val listOfQuestionsLight =
                context.resources.getStringArray(R.array.questions_game_ny_light).toMutableList()
        val listOfQuestionsHard =
                context.resources.getStringArray(R.array.questions_game_ny_hard).toMutableList()
        for (i in 1..30) {
            listOfQuestion.add(QuestionUI(
                    questionFrameLight,
                    nextQuestionButtonLight,
                    listOfQuestionsLight[i-1],
                    questionTextColorLight,
                    context.resources.getIdentifier(
                            "questionimage_nhie_ny_light_$i",
                            "drawable",
                            context.packageName
                    )
            ))
            listOfQuestion.add(QuestionUI(
                    questionFrameHard,
                    nextQuestionButtonHard,
                    listOfQuestionsHard[i-1],
                    questionTextColorHard,
                    context.resources.getIdentifier(
                            "questionimage_nhie_ny_hard_$i",
                            "drawable",
                            context.packageName
                    )
            ))
        }
        listOfQuestion.shuffle()
        return GameUICharacteristic(listOfQuestion, gameLogo, previewImage, startGameButton, gameName)
    }
}

