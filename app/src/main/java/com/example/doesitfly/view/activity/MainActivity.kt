package com.example.doesitfly.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.doesitfly.R
import com.example.doesitfly.api.RequestUtils
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.databinding.ActivityMainBinding
import com.example.doesitfly.utils.URL_API_FLYING_SITE
import com.example.doesitfly.viewModel.ListFlyingSiteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
//    private val viewModel by lazy { ViewModelProvider(this)[ListFlyingSiteViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFlyingSite()

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

    fun loadFlyingSite() : List<FlyingSiteBean> {

        var listFlyingSiteBean = listOf<FlyingSiteBean>()

        lifecycleScope.launch(Dispatchers.IO) {

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
    }

}