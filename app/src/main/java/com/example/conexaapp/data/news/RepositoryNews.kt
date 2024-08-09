package com.example.conexaapp.data.news

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryNews() {

    private val retrofit = Retrofit.Builder().baseUrl("http://demo0803044.mockable.io/").addConverterFactory(GsonConverterFactory.create()).build()

    suspend fun getNews(): List<com.example.conexaapp.model.news.NewsModel>?{
        return retrofit.create(News::class.java).getNews().body()
    }

}