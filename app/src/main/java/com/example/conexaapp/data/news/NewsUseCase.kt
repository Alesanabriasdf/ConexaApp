package com.example.conexaapp.data.news

import com.example.conexaapp.model.news.NewsModel

class NewsUseCase(private val repository: RepositoryNews) {

    suspend operator fun invoke(): List<NewsModel>? {
        return repository.getNews()
    }
}