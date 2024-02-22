package com.example.bluemoney.data.remote

import retrofit2.http.Field
import com.example.bluemoney.data.model.PaypalAuthModel
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PaypalService {
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("v1/oauth2/token")
    suspend fun getAccessToken(
        @Field("grant_type") key: String
    ): PaypalAuthModel

    @POST("v2/checkout/orders")
    suspend fun createOrder(
        @Header("Authorization") accessToken: String,
        @Body orderDetails: OrderDetails
    ): OrderResponse
}

data class OrderDetails(
    val intent: String,
    val purchase_units: List<PurchaseUnit>
)

data class PurchaseUnit(
    val amount: Amount
)

data class Amount(
    val currency_code: String,
    val value: String
)

data class OrderResponse(
    val id: String,
    val links: List<Link>
)

data class Link(
    val href: String,
    val rel: String,
    val method: String
)
