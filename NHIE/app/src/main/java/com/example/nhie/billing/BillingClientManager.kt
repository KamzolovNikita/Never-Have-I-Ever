package com.example.nhie.billing

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.android.billingclient.api.*
import com.example.nhie.store.StoreItem
import kotlinx.coroutines.coroutineScope

const val PREF_FILE = "PURCHASED_ITEMS"

class BillingClientManager(private val context: Context, private val listener: PurchasesUpdatedListener) {
    private val preferenceObject: SharedPreferences = context.getSharedPreferences(PREF_FILE, 0)
    private val preferenceEditObject: SharedPreferences.Editor
        get() = preferenceObject.edit()

    private var billingClient = initBillingClient()

    private fun initBillingClient() =
        BillingClient.newBuilder(context).enablePendingPurchases().setListener(listener).build()

    fun initPurchaseFlowOfItem(storeItem: StoreItem) {
        if(getPurchaseItemValueFromPrefs(storeItem.id)) {
            println("already purchased")
            return
        }

        if(billingClient.isReady) {
            initiatePurchase(storeItem.id)
        }
        else {
            TODO()
        }

    }

    private fun getPurchaseItemValueFromPrefs(PURCHASE_KEY: String): Boolean {
        return preferenceObject.getBoolean(PURCHASE_KEY, false)
    }

    private fun initiatePurchase(id: String) {
        val skuList: MutableList<String> = ArrayList()
        skuList.add(id)
        val params = SkuDetailsParams.newBuilder()
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP)
        billingClient.querySkuDetailsAsync(params.build()
        ) { billingResult, skuDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                if (skuDetailsList != null && skuDetailsList.size > 0) {
                    val flowParams = BillingFlowParams.newBuilder()
                        .setSkuDetails(skuDetailsList[0])
                        .build()
                    billingClient.launchBillingFlow(context as Activity, flowParams)
                }
                else {
                    //try to add item/product id "p1" "p2" "p3" inside managed product in google play console
                }
            }
            else {

            }
        }
    }

    fun queryPurchases(skuType: String): Purchase.PurchasesResult {
        return billingClient.queryPurchases(skuType)
    }
}