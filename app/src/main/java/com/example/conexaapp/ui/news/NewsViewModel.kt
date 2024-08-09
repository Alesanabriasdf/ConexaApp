package com.example.conexaapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conexaapp.data.news.NewsUseCase
import com.example.conexaapp.data.news.RepositoryNews
import com.example.conexaapp.model.news.NewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: RepositoryNews = RepositoryNews()) : ViewModel() {

    private val _newsModel = MutableLiveData<List<NewsModel>>()
    val newsModel: LiveData<List<NewsModel>> = _newsModel

    fun getNews(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _newsModel.postValue(NewsUseCase(repository).invoke())
            } catch (e: Exception){
                e.printStackTrace()
                //bring some feedback to the user.
            }
        }
    }
}