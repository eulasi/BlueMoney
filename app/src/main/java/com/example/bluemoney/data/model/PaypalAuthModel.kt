package com.example.bluemoney.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PaypalAuthModel(
    val scope: String? = "",
    val access_token: String? = "",
    val token_type: String? = "",
    val app_id: String? = "",
    val expires_in: Int? = 0,
    val nonce: String? = ""
)

val jsonResponse = """
{
    "scope": "https://uri.paypal.com/services/invoicing https://uri.paypal.com/services/vault/payment-tokens/read https://uri.paypal.com/services/disputes/read-buyer https://uri.paypal.com/services/payments/realtimepayment https://uri.paypal.com/services/disputes/update-seller openid https://uri.paypal.com/services/payments/payment/authcapture https://uri.paypal.com/services/disputes/read-seller Braintree:Vault https://uri.paypal.com/services/payments/refund https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/payments/.* https://uri.paypal.com/services/reporting/search/read https://uri.paypal.com/payments/payouts https://uri.paypal.com/services/vault/payment-tokens/readwrite https://api.paypal.com/v1/vault/credit-card/.* https://uri.paypal.com/services/subscriptions https://uri.paypal.com/services/applications/webhooks",
    "access_token": "A21AAIwF7NWh4vEi0H6WS-vbOnIpiTNl3lrWSE9RmJZwz06L7fltDs_B5JQv44tBpRtebcW6dtHzdcD78aXziLOOQoIFQFBUA",
    "token_type": "Bearer",
    "app_id": "APP-80W284485P519543T",
    "expires_in": 32399,
    "nonce": "2024-02-22T06:18:43ZIRzDiyX35csDrPMj_5NxtZmSyzVLcsCw4BVS8wVOknk"
}
""".trimIndent()
