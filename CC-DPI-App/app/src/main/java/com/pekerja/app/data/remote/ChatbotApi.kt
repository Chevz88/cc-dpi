package com.pekerja.app.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ChatbotApi {
    @GET("chat")
    suspend fun getAnswer(@Query("question") question: String): ChatResponse
}
