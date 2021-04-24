package com.example.fitnesstracker.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.fitnesstracker.repository.BitrootRepository
import com.example.fitnesstracker.room.BitrootEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BitrootViewModel(application: Application):AndroidViewModel(application) {

    private val repository=BitrootRepository(application)

    private val _result=MutableLiveData<BitrootEntity>()

    val result:LiveData<BitrootEntity>
    get() = _result
    init {
        getData()
    }

    fun getData(){
       viewModelScope.launch(Dispatchers.IO) {
           repository.insertData()
           _result.postValue(repository.getData())
       }
    }
}