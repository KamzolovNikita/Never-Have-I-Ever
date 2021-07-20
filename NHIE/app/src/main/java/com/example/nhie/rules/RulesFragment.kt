package com.example.nhie.rules

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nhie.databinding.FragmentRulesBinding
import com.example.nhie.util.Animation


class RulesFragment : Fragment() {
    private lateinit var viewModel: RulesViewModel

    private lateinit var binding: FragmentRulesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRulesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(RulesViewModel::class.java)

        binding.rulesViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.eventBackNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedTextClick(binding.fragmentRulesTxtBack)
                findNavController().popBackStack()
                viewModel.onNavigateFinish()
            }
        })

        return binding.root
    }
}