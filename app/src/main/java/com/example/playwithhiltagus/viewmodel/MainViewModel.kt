package com.example.playwithhiltagus.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.playwithhiltagus.dataclasses.RecyclerData
import com.example.playwithhiltagus.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(){

    var liveDataList: MutableLiveData<List<RecyclerData>> = MutableLiveData()

    fun getLiveDataOberver(): MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadOfListData(){
        repository.makeApiCall("ny", liveDataList)
    }

}