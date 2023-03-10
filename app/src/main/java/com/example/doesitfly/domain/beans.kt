package com.example.doesitfly.beans

//TODO : Domain folder is for data models
/* -------------------------------- */
// API Weather Beacon Bean
/* -------------------------------- */

data class WeatherBeaconBean (
    var idbalise       : String,
    var date           : String,
    var vitesseVentMoy : String,
    var vitesseVentMax : String,
    var vitesseVentMin : String,
    var directVentMoy  : String,
    var temperature    : String
)

/* -------------------------------- */
// API Flying Site
/* -------------------------------- */
data class ResultBean(
    val results: List<FlyingSiteBean>
)

//data class FlyingSiteBean(
//    var id                : String,
//    var numero            : String,
//    var nom               : String,
//    var cp                : String,
//    var ville             : String,
//    var lat               : String,
//    var lon               : String,
//    var alt               : String,
//    var ventFavo          : String,
//    var ventDefavo        : String,
//    var balise            : String
//
//    //var siteType          : String? = null,
//    //var siteSousType      : String? = null,
//    //var pratiques         : String? = null,
//    //var acces             : String? = null,
//    //var trajetParcking    : String? = null,
//    //var trajetAtteroDeco  : String? = null,
//    //var handi             : String? = null,
//    //var conditionsIdeales : String? = null,
//    //var webcam            : String? = null,
//    //var signaletique      : String? = null,
//    //var description       : String? = null,
//    //var restrictions      : String? = null,
//    //var regAerienne       : String? = null,
//    //var dangers           : String? = null,
//    //var numeroCross       : String? = null,
//    //var dateModification  : String? = null
//)

class FlyingSiteBeanList : ArrayList<FlyingSiteBean>()

data class FlyingSiteBean(
    val acces: String,
    val alt: String,
    val balise: String,
    val conditions_ideales: String,
    val cp: String,
    val dangers: String,
    val date_modification: String,
    val description: String,
    val handi: String,
    val id: String,
    val lat: String,
    val lon: String,
    val nom: String,
    val numero: String,
    val numero_cross: String,
    val pratiques: String,
    val reg_aerienne: String,
    val restrictions: String,
    val signaletique: String,
    val site_sous_type: String,
    val site_type: String,
    val sous_nom: String,
    val suid: String,
    val trajet_attero_deco: String,
    val trajet_parcking: String,
    val vent_defavo: String,
    val vent_favo: String,
    val ville: String,
    val webcam: String
)