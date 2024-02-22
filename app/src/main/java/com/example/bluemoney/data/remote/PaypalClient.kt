package com.example.bluemoney.data.remote

import com.example.bluemoney.util.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object PaypalClient {
    private const val AUTH_URL = "https://api-m.sandbox.paypal.com/"
    private const val PAYPAL_CLIENT_ID =
        "ATVSUR-QUB8d1EgKy0inuYGL6tNEe9hgde9vevowE1BFHlutYZJiEYuGiRKOJcw1xHOhI9lGCOSz8BO_"
    private const val PAYPAL_CLIENT_SECRET =
        "EMG8XV8_Xd-6spcrN7nB4562JZtckx5QaDvSU8QtolnUk45ng6G3jvVqzFlSL5BH4mG7wHfUUgHrPXN7"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .addInterceptor(
            AuthInterceptor(
                PAYPAL_CLIENT_ID,
                PAYPAL_CLIENT_SECRET
            )
        )
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(AUTH_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: PaypalService = retrofit.create(PaypalService::class.java)
}