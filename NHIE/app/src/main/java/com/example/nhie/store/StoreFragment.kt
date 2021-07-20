package com.example.nhie.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.example.nhie.billing.BillingClientManager
import com.example.nhie.databinding.FragmentStoreBinding
import com.example.nhie.util.Animation

class StoreFragment : Fragment(){
    private lateinit var viewModel: StoreViewModel

    private lateinit var binding: FragmentStoreBinding
    private var adapter = StoreAdapter(StoreItemListener {
    })



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)



        binding.storeViewModel = viewModel

        binding.fragmentStoreRwItemsForPurchase.adapter = adapter
        binding.lifecycleOwner = this
        
        adapter.data = viewModel.storeItems

        viewModel.eventBackNavigate.observe(viewLifecycleOwner, { event ->
            if(event) {
                Animation.animatedTextClick(binding.fragmentStoreTxtBack)
                findNavController().popBackStack()
                viewModel.onNavigateFinish()
            }
        })



        return binding.root
    }



}