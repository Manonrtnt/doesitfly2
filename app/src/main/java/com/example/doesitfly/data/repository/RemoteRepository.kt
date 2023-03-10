package com.example.doesitfly.data.repository

import android.util.Log
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.data.remote.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class RemoteRepository(private val apiService: ApiService) {

    //TODO: BUSINESS LOGIC TO PERFORM OUR API METHODS
    fun fetchData(): List<FlyingSiteBean> {
        val jsonData = apiService.fetchData()
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, FlyingSiteBean::class.java)
        val adapter = moshi.adapter<List<FlyingSiteBean>>(type)
        Log.d("TODO 0", jsonData.toString())
        return adapter.fromJson(jsonData) ?: emptyList()
    }
}