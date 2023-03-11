package com.example.doesitfly.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.doesitfly.R
import com.example.doesitfly.databinding.ActivityMainBinding
import com.example.doesitfly.presentation.viewmodel.ListFlyingSiteViewModel


class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    // Declare viewModel here
    private lateinit var listFlyingSiteViewModel: ListFlyingSiteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Init viewModel
        listFlyingSiteViewModel = ViewModelProvider(this).get(ListFlyingSiteViewModel::class.java)

        // getData with viewmodel method getFlyingSites
        val flyingSites = listFlyingSiteViewModel.getFlyingSites()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.tab_item_map -> {
                true
            }
            R.id.tab_item_list -> {
                val intent = Intent(this, ListFlyingSiteActivity::class.java)
                startActivity(intent);
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}