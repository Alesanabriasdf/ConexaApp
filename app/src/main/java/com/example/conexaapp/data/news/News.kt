package com.example.conexaapp.data.news

import com.example.conexaapp.model.news.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface News {
    @GET("endpointnews")
    suspend fun getNews(): Response<List<NewsModel>>
}