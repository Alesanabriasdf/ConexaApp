package com.example.conexaapp.ui.news

import com.example.conexaapp.data.news.RepositoryNews
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class NewsViewModelTest{

    private lateinit var newsViewModelMocked: NewsViewModel
    private lateinit var mockedRepository: RepositoryNews

    @Before
    fun setUp(){
        mockedRepository = mockk()
        newsViewModelMocked = NewsViewModel(mockedRepository)
    }
    @Test
    fun errorCase(){
        coEvery { mockedRepository.getNews() } returns null

        newsViewModelMocked.getNews()

        assert(newsViewModelMocked.newsModel.value == null)
    }
}