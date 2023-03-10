package com.example.doesitfly.data.remote

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class ApiService() {
    // APISERVICE CLASS FOR NETWORK METHODS
    fun fetchData(): String? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("http://data.ffvl.fr/json/sites.json")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            return response.body?.string()
        }
    }
}
