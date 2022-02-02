package com.example.playwithhiltagus.di

import com.example.playwithhiltagus.network.RetrofitServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //ws_datos.php?operacion=155&deposito=126
    val baseURL = "https://api.github.com/search/"



    //Instance particular retrofit
    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit) : RetrofitServices = retrofit.create(RetrofitServices::class.java)


    //Instance of retrofit
    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
             .baseUrl(baseURL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()


}