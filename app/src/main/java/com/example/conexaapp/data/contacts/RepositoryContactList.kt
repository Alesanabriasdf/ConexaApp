package com.example.conexaapp.data.contacts

import com.example.conexaapp.data.newdetail.NewDetail
import com.example.conexaapp.model.contacts.ContactModel
import com.example.conexaapp.model.news.NewDetailModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryContactList {

    private val retrofit = Retrofit.Builder().baseUrl("http://demo0803044.mockable.io/").addConverterFactory(GsonConverterFactory.create()).build()

    suspend fun getContactList(): List<ContactModel?>?{
        return retrofit.create(Contacts::class.java).getContacts().body()
    }

}