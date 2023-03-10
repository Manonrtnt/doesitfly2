package com.example.doesitfly.api

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import com.example.doesitfly.beans.FlyingSiteBean
import com.example.doesitfly.beans.ResultBean
import com.example.doesitfly.utils.URL_API_FLYING_SITE
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter
import java.net.URL

object RequestUtils {
    //TODO : TO DELETE OUR NETWORK IS IN APISERVICE CLASS
    private val client = OkHttpClient()
    private val gson = Gson()


    /*fun sendGet(url: String): String? {
        var result: String? = null

        try {
            // Create URL
            val url = URL(url)
            // Build request
            val request = Request.Builder().url(url).build()
            // Execute request
            val response = client.newCall(request).execute()
            result = response.body?.string()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }*/




//        //Contrôle de donnée
//        //construire requete
//        //Faire la requete
//        val json = sendGet(URL_API_FLYING_SITE)
//        Log.d("Tag", "data: $json")
//        //Parse le résultat
//        var flyingSite = gson.fromJson(json, Array<FlyingSiteBean>::class.java)
//        //Contrôle
//        //Extraction
//        Log.d("TEST", flyingSite.asList().toString())
//        return flyingSite.asList()





//    //Méthode qui prend en entrée une url, execute la requête et retourne le code HTML/JSON reçu
//    private fun sendGet(url: String): String {
//        println("url : $url")
//        //Création de la requête
//        val request = Request.Builder().url(url).build()
//        //Execution de la requête
//        return client.newCall(request).execute().use { //it:Response
//            //use permet de fermer la réponse qu'il y ait ou non une exception
//            //Analyse du code retour
//            if (!it.isSuccessful) {
//                throw Exception("Réponse du serveur incorrect :${it.code}")
//            }
//            //Résultat de la requête
//            it.body.string()
//        }
//    }

//    fun loadFlyingSite(): List<FlyingSiteBean> {
//        val json = sendGet(URL_API_FLYING_SITE)
//        println("Réponse : $json")
//        Log.d("TEST JSON", json)
//        return gson.fromJson(json, object : TypeToken<List<FlyingSiteBean>>() {}.type)
//    }

//    private fun sendGet(url: URL): String {
//        Log.d("sendGet", "url : $url")
//        val request = Request.Builder()
//            .url(url)
//            .build()
//        try {
//            val response = client.newCall(request).execute()
//            if (!response.isSuccessful) {
//                throw Exception("Réponse du serveur incorrect :${response.code}")
//            }
//            return response.body.string()
//        } catch (e: Exception) {
//            throw Exception("La requête GET a échoué : $url")
//        } finally {
//            val sw = StringWriter()
//            val pw = PrintWriter(sw)
//            try {
//                throw RuntimeException("test")
//            } catch (e: RuntimeException) {
//                e.printStackTrace(pw)
//                Log.d("sendGet", "Exception complète : $sw")
//            }
//        }
//    }

    //    fun loadWeatherBeacon(idBeacon: Int) : WeatherBeaconBean{
//        //Contrôle de donnée
//        //construire requete
//        //Faire la requete
//        val json = sendGet(URL_API_WEATHER_BEACON + idBeacon)
//        //Parse le résultat
//        val weatherBeacon = gson.fromJson(json, WeatherBeaconBean::class.java)
//        //Contrôle
//        //Extraction
//
//        return weatherBeacon
//    }
}