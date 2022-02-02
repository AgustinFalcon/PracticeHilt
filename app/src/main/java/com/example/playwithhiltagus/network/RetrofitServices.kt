package com.example.playwithhiltagus.network

import com.example.playwithhiltagus.dataclasses.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    //End point
    @GET("repositories")
    fun getDataFromApi(@Query("q")query: String) : Call<RecyclerList>
}