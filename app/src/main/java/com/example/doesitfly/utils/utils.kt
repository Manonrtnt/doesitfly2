package com.example.doesitfly.utils

import java.text.SimpleDateFormat
import java.util.*

class utils {

    fun convertDegreesToCompassDirection(degrees: Int): String {
        val directions = arrayOf("N", "NE", "E", "SE", "S", "SW", "W", "NW")
        // La variable index est calculée en ajoutant 22,5 degrés à la valeur d'entrée pour
        // décaler la plage de degrés de chaque direction de 22,5 degrés vers le haut (par exemple,
        // la plage de degrés pour la direction Nord sera de 0 à 45 degrés au lieu de 0 à 22,5 degrés).
        // Cette valeur est ensuite divisée par 45 pour obtenir l'index de la direction correspondante
        // dans le tableau directions. La fonction toInt() est utilisée pour arrondir à l'entier
        // inférieur.
        val index = ((degrees + 22.5) / 45).toInt() % 8
        return directions[index]
    }

    fun convertDateToTimestampSeconds(dateString: String): Long {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = dateFormat.parse(dateString)
        return date?.time?.div(1000) ?: 0
    }
}