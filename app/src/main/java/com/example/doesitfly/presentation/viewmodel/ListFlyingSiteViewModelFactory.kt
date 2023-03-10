package com.example.doesitfly.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.doesitfly.data.remote.ApiService

//La classe Factory est utilisée pour créer une instance du ViewModel et
// lui fournir ses dépendances. Cela permet d'injecter des dépendances
// dans le ViewModel sans avoir à passer par le constructeur,
// qui est utilisé par le système pour recréer l'instance du ViewModel
// après une rotation d'écran ou lorsqu'il est recréé pour une autre raison.
class ListFlyingSiteViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListFlyingSiteViewModel::class.java)) {
            return ListFlyingSiteViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
