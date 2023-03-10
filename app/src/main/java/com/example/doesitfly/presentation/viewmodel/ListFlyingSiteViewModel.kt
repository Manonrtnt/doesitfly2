package com.example.doesitfly.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.data.remote.ApiService
import com.example.doesitfly.data.repository.RemoteRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class ListFlyingSiteViewModel(apiService: ApiService) : ViewModel() {
    val data: MutableLiveData<List<FlyingSiteBean>> = MutableLiveData<List<FlyingSiteBean>>().apply { value = emptyList() }
    var runInProgress = MutableLiveData(false)
    var errorMessage = MutableLiveData("ERROR")

    private val _myData = MutableLiveData<List<FlyingSiteBean>>()
    val myData: LiveData<List<FlyingSiteBean>> = _myData

    var repo = RemoteRepository(apiService)

    init {
        viewModelScope.launch {
            _myData.value = repo.fetchData()
        }
    }

    //TODO : CLEAN CODE
    /** load flying site data : FlyingSiteBean from API */
//    fun loadData(){
//        // Reset data
////        data.postValue(null)
//        errorMessage.postValue(null)
//        runInProgress.postValue(true)
//
//        try {
//            data.postValue(RequestUtils.loadFlyingSite())
//
//        } catch (e : Exception) {
//            e.printStackTrace()
//            errorMessage.postValue("Connection error")
//        }
//
////        runInProgress.postValue(false)
//    }

    //TODO : CLEAN CODE
    /*fun loadData() {
        viewModelScope.launch {
            try {
                val sites = withContext(Dispatchers.IO) {
                    // Effectuez votre requête réseau ici
                    // Cette ligne de code doit être exécutée sur un thread différent du thread principal
                    loadFlyingSite()
                }

                // Mettez à jour les données de l'objet MutableLiveData
                data.value = sites
                errorMessage.value = null
            } catch (e: Exception) {
                // Si une erreur se produit, mettez à jour l'objet MutableLiveData d'erreur
                errorMessage.value = e.message
            }
        }
    }*/

    //TODO: this methods work and dont forget HTTPS otherwise it won't work
    //private val _myData = MutableLiveData<List<FlyingSiteBean>>()
    //val myData: LiveData<List<FlyingSiteBean>> = _myData

    /*fun fetchData() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://data.ffvl.fr/json/sites.json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("TODO -1","TEST TEST TEST")
                Log.d("TODO ERROR",e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val jsonData = response.body?.string()
                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
                val adapter = moshi.adapter(FlyingSiteBean::class.java)
                //val myDataList = adapter.fromJson(jsonData)
                //_myData.postValue(myDataList)
                Log.d("TODO 0","TEST TEST TEST")
                Log.d("TODO 1",jsonData.toString())
            }
        })
    }*/

    /*fun loadFlyingSite() : List<FlyingSiteBean> {

        var listFlyingSiteBean = listOf<FlyingSiteBean>()

        viewModelScope.launch(Dispatchers.IO) {

            val result = RequestUtils.sendGet(URL_API_FLYING_SITE)
            if (result != null) {
                try {
                    Log.d("RESULT", result)
                    // Parse result string JSON to data class
//                    listFlyingSiteBean = Klaxon().parse<List<FlyingSiteBean>>(result)
                }
                catch(err:Error) {
                    print("Error when parsing JSON: "+err.localizedMessage)
                }
            }
            else {
                println("Error: Get request returned no response")
            }

        }
        return listFlyingSiteBean
    }*/

}