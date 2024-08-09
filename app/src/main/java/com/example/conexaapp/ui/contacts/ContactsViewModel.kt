package com.example.conexaapp.ui.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conexaapp.data.contacts.ContactListUseCase
import com.example.conexaapp.data.contacts.RepositoryContactList
import com.example.conexaapp.model.contacts.ContactModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactsViewModel : ViewModel() {

    private val _contactList = MutableLiveData<List<ContactModel?>>()
    val contactList: LiveData<List<ContactModel?>> = _contactList

    fun getContactList(){
        viewModelScope.launch(Dispatchers.IO) {
            _contactList.postValue(ContactListUseCase(RepositoryContactList()).invoke())
        }
    }
}