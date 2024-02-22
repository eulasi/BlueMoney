package com.example.bluemoney.util

import com.example.bluemoney.data.remote.PAYPAL_CLIENT_ID
import okhttp3.Credentials.basic
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class AuthInterceptor(
    user: String?, password: String?
) : Interceptor {
    private val credentials: String

    init {
        credentials = basic(PAYPAL_CLIENT_ID, "")
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", credentials).build()

        return chain.proceed(authenticatedRequest)
    }
}
