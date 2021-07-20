package com.example.nhie.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nhie.databinding.FragmentGameBinding
import com.example.nhie.util.Animation


class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory

    private lateinit var binding: FragmentGameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGameBinding.inflate(inflater, container, false)

        viewModelFactory =
            GameViewModelFactory(GameFragmentArgs.fromBundle(requireArguments()).gameData)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameViewModel::class.java)

        binding.gameViewModel = viewModel
        binding.fragmentGameImgLogo.setImageResource(viewModel.gameUI.gameLogo)

        binding.lifecycleOwner = this

        viewModel.eventBackNavigate.observe(viewLifecycleOwner, { event ->
            if (event) {
                Animation.animatedTextClick(binding.fragmentGameTxtBack)
                findNavController().popBackStack()
                viewModel.onNavigateFinish()
            }
        })

        viewModel.eventNextButtonPressed.observe(viewLifecycleOwner, {event ->
            if (event) {
                Animation.animatedButtonClick(binding.fragmentGameBtnNextQuestion)
                viewModel.onNextButtonPressedComplete()
            }
        })

        viewModel.eventRestartTextPressed.observe(viewLifecycleOwner, {event ->
            if (event) {
                Animation.animatedTextClick(binding.fragmentGameTxtStartOver)
                viewModel.onRestartTextPressedComplete()
            }
        })

        viewModel.curQuestionImage.observe(viewLifecycleOwner, { image ->
            binding.fragmentGameImgQuestion.setImageResource(image)
        })

        viewModel.curNextQuestionButton.observe(viewLifecycleOwner, { background ->
            binding.fragmentGameBtnNextQuestion.setBackgroundResource(background)
        })

        viewModel.curQuestionFrame.observe(viewLifecycleOwner, { background ->
            binding.fragmentGameViewQuestionFrame.setBackgroundResource(background)
        })

        viewModel.curQuestionTextColor.observe(viewLifecycleOwner, { color ->
            binding.fragmentGameTxtQuestion.setTextColor(color)
        })

        return binding.root
    }

}