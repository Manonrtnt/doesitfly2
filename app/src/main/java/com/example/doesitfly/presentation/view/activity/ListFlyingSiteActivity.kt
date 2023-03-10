package com.example.doesitfly.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doesitfly.databinding.ActivityListBinding
import com.example.doesitfly.presentation.view.adapter.ListCardAdapter
import com.example.doesitfly.presentation.viewmodel.ListFlyingSiteViewModel

class ListFlyingSiteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityListBinding.inflate(layoutInflater)}
    private val viewModel by lazy { ViewModelProvider(this)[ListFlyingSiteViewModel::class.java] }
    private lateinit var adapter : ListCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            // Do something with savedInstanceState
            Log.d("savedInstanceState", "NULL")
        } else {
            Log.d("savedInstanceState", "PAS NULL")
        }

        // Chargez vos données dans votre ViewModel
        viewModel.fetchData()

//        // Reactive programming
//        observe()

        binding.textViewTest.text = viewModel.errorMessage.value

        // Initialisez votre adaptateur avec une liste vide
        adapter = ListCardAdapter(viewModel.data.value ?: emptyList())

        // Configurez votre RecyclerView avec votre adaptateur et votre LinearLayoutManager
        binding.recyclerViewList.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewList.adapter = adapter

        // Mettez en place un observateur sur les données MutableLiveData dans votre ViewModel
        viewModel.data.observe(this, Observer {
            // Obtenez la liste de données actuelle avec getValue() et mettez à jour les données de votre adaptateur avec les nouvelles données
            adapter.updateData(viewModel.data.value ?: emptyList())
        })
    }

    /** Live data for reactive programming */
    private fun observe() {
        // Post value déclanche : observe ce qu'il se passe
        viewModel.errorMessage.observe(this){
            if(viewModel.errorMessage != null){
//                binding.tvWeather.isVisible = true
//                binding.tvWeather.text = it
                // add error message to the list
            } else {
                // do nothing
            }
        }

        viewModel.data.observe(this){
            binding.recyclerViewList.adapter = adapter
        }

        viewModel.runInProgress.observe(this) {
//            binding.progressBar.isVisible = it
        }

    }

}