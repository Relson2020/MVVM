package com.example.mvvmarchietucture.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// Repository Class
class Repository(private val apiInterface: ApiInterface){

    private var apiResultMutableLiveData : MutableLiveData<List<MyDataItem>> = MutableLiveData()
    val apiResultLiveData : LiveData<List<MyDataItem>>
    get() = apiResultMutableLiveData

    /**
     * Get the data from the API
     *
     * @return Result from the API
    */
    suspend fun getData() {
        val result = apiInterface.getData()
        apiResultMutableLiveData.postValue(result)
    }
}