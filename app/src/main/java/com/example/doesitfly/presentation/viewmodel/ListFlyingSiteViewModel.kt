package com.example.doesitfly.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.data.repository.RemoteRepository

class ListFlyingSiteViewModel() : ViewModel() {
    val data: MutableLiveData<List<FlyingSiteBean>> = MutableLiveData<List<FlyingSiteBean>>().apply { value = emptyList() }
    var runInProgress = MutableLiveData(false)
    var errorMessage = MutableLiveData("ERROR")

    // This block can be used to init some var or excute methods..
    init {}

    // Init BL (Business Logic)
    private val repository = RemoteRepository()

    // getFlyingSites method is used to get data from BL
    fun getFlyingSites(): List<FlyingSiteBean> {
        return repository.getFlyingSitesFromApi()
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


    // TODO: Clean code
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