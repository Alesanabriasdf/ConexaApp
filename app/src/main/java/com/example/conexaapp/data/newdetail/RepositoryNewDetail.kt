package com.example.conexaapp.data.newdetail

import com.example.conexaapp.model.news.NewDetailModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryNewDetail {

    private val retrofit = Retrofit.Builder().baseUrl("http://demo0803044.mockable.io/").addConverterFactory(GsonConverterFactory.create()).build()

    suspend fun getNewDetail(id: String): NewDetailModel?{
        return retrofit.create(NewDetail::class.java).getNewDetail("endpoint-new-detail/$id").body()
    }

}