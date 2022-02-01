package com.example.mvvmarchietucture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmarchietucture.model.MyDataItem
import com.example.mvvmarchietucture.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    /**
     * Calling getData function in Repository
    */
    fun get(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getData()
        }
    }

    val apiResultLiveData : LiveData<List<MyDataItem>>
    get() = repository.apiResultLiveData
}