package com.example.nhie.preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nhie.databinding.FragmentGamePreviewBinding
import com.example.nhie.util.Animation
import com.example.nhie.util.GameCreator
import com.example.nhie.util.GameUICharacteristic


class GamePreviewFragment : Fragment() {
    private lateinit var viewModel: GamePreviewViewModel

    private lateinit var binding: FragmentGamePreviewBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGamePreviewBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(GamePreviewViewModel::class.java)

        binding.gamePreviewViewModel = viewModel
        binding.lifecycleOwner = this

        val game = GameCreator(GamePreviewFragmentArgs.fromBundle(requireArguments()).gameType)
        val gameUI : GameUICharacteristic = game.gameInit(this.context)
        setUI(gameUI)


        viewModel.eventGameNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedButtonClick(binding.fragmentGamePreviewBtnStartGame)
                val action = GamePreviewFragmentDirections.actionGamePreviewFragmentToGameFragment(gameUI)
                findNavController().navigate(action)
                viewModel.onNavigateFinish()
            }
        })

        viewModel.eventBackNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedTextClick(binding.fragmentGamePreviewTxtBack)
                findNavController().popBackStack()
                viewModel.onNavigateFinish()
            }
        })

        return binding.root
    }

    private fun setUI(gameUI: GameUICharacteristic) {
        binding.fragmentGamePreviewBtnStartGame.setBackgroundResource(gameUI.startGameButton)
        binding.fragmentGamePreviewImgPrimary.setImageResource(gameUI.previewImage)
        binding.fragmentGamePreviewImgLogo.setImageResource(gameUI.gameLogo)
        binding.fragmentGamePreviewTxtHeader.text = gameUI.gameName
    }



}