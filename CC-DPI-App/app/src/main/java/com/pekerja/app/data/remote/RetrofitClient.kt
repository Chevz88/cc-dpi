package com.pekerja.app.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.0.7:5000/" // Ganti dengan ngrok URL jika dibutuhkan

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val chatbotApi: ChatbotApi by lazy {
        retrofit.create(ChatbotApi::class.java)
    }
}
