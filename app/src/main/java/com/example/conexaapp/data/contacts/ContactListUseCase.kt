package com.example.conexaapp.data.contacts

import com.example.conexaapp.model.contacts.ContactModel

class ContactListUseCase(private val repository: RepositoryContactList) {

    suspend operator fun invoke(): List<ContactModel?>? {
        return repository.getContactList()
    }
}