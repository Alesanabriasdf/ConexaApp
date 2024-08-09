package com.example.conexaapp.data.newdetail

import com.example.conexaapp.model.news.NewDetailModel

class NewDetailUserCase(private val repository: RepositoryNewDetail) {

    suspend operator fun invoke(id:String): NewDetailModel? {
        return repository.getNewDetail(id)
    }
}