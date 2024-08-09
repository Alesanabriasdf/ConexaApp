package com.example.conexaapp.data.newdetail

import com.example.conexaapp.model.news.NewDetailModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface NewDetail {
    @GET
    suspend fun getNewDetail(
        @Url url:String
    ): Response<NewDetailModel?>
}