package com.example.nhie.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nhie.databinding.FragmentMainBinding
import com.example.nhie.util.Animation
import com.example.nhie.util.GameType


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.mainViewModel = viewModel

        viewModel.eventFirstGameNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedButtonClick(binding.fragmentMainBtnGameOne)
                val action = MainFragmentDirections.actionMainFragmentToGamePreviewFragment(GameType.FIRST)
                findNavController().navigate(action)
                viewModel.onNavigateFinish()
            }
        })

        viewModel.eventSecondGameNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedButtonClick(binding.fragmentMainBtnGameTwo)
                val action = MainFragmentDirections.actionMainFragmentToGamePreviewFragment(GameType.SECOND)
                findNavController().navigate(action)
                viewModel.onNavigateFinish()
            }
        })

        viewModel.eventNYGameNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedButtonClick(binding.fragmentMainBtnGameNy)
                val action = MainFragmentDirections.actionMainFragmentToGamePreviewFragment(GameType.NEW_YEAR)
                findNavController().navigate(action)
                viewModel.onNavigateFinish()

            }
        })

        viewModel.eventStoreNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                val action = MainFragmentDirections.actionMainFragmentToStoreFragment()
                findNavController().navigate(action)
                viewModel.onNavigateFinish()
            }
        })

        viewModel.eventRulesNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                val action = MainFragmentDirections.actionMainFragmentToRulesFragment()
                findNavController().navigate(action)
                viewModel.onNavigateFinish()
            }
        })

        return binding.root
    }

}