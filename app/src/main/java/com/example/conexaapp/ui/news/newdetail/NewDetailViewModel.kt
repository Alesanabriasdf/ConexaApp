package com.example.conexaapp.ui.news.newdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conexaapp.data.newdetail.NewDetailUserCase
import com.example.conexaapp.data.newdetail.RepositoryNewDetail
import com.example.conexaapp.model.news.NewDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewDetailViewModel : ViewModel() {


    private val _newDetailModel = MutableLiveData<NewDetailModel?>()
    val newDetailModel: LiveData<NewDetailModel?> = _newDetailModel

    fun getNewDetail(id:String){
        viewModelScope.launch(Dispatchers.IO) {
            val call = _newDetailModel.postValue(NewDetailUserCase(RepositoryNewDetail()).invoke(id))
            call.apply {

            }
        }
    }
}