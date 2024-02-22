package com.example.bluemoney.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluemoney.data.model.PaypalAuthModel
import com.example.bluemoney.data.remote.Amount
import com.example.bluemoney.data.remote.OrderDetails
import com.example.bluemoney.data.remote.PaypalClient
import com.example.bluemoney.data.remote.PurchaseUnit
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class BlueMoneyViewModel : ViewModel() {

    private val grantValue = "client_credentials"

    private var _accessToken = MutableStateFlow<PaypalAuthModel?>(null)

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    init {
        getAccessToken()
    }

    private fun getAccessToken() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = PaypalClient.service.getAccessToken(grantValue)

            if (result.access_token != null) {
                _accessToken.value = result
            }
        }
    }

    fun approveOrder(context: Context) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val accessToken = _accessToken.value?.access_token
            if (accessToken != null) {
                val orderDetails = OrderDetails(
                    intent = "CAPTURE",
                    purchase_units = listOf(
                        PurchaseUnit(
                            amount = Amount(
                                currency_code = "USD",
                                value = "99.00"
                            )
                        )
                    )
                )

                val orderResponse =
                    PaypalClient.service.createOrder("Bearer $accessToken", orderDetails)
                val approveLink = orderResponse.links.firstOrNull { it.rel == "approve" }
                val checkoutUrl = approveLink?.href

                if (checkoutUrl != null) {
                    withContext(Dispatchers.Main) {
                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            data = Uri.parse(checkoutUrl)
                        }
                        context.startActivity(intent)
                    }
                }
            }
        }
    }
}

