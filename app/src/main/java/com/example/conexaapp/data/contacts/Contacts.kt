package com.example.conexaapp.data.contacts

import com.example.conexaapp.model.contacts.ContactModel
import retrofit2.Response
import retrofit2.http.GET

interface Contacts {
    @GET("endpoint-contacts")
    suspend fun getContacts(): Response<List<ContactModel?>?>

}