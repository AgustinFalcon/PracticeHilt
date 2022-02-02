package com.example.playwithhiltagus.repository

import androidx.lifecycle.MutableLiveData
import com.example.playwithhiltagus.dataclasses.RecyclerData
import com.example.playwithhiltagus.dataclasses.RecyclerList
import com.example.playwithhiltagus.network.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val retroInstance: RetrofitServices){

    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecyclerData>>){
        val call: Call<RecyclerList> = retroInstance.getDataFromApi(query)
        call.enqueue(object : Callback<RecyclerList>{

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }

}