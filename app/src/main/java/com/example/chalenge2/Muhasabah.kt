package com.example.chalenge2


data class Muhasabah(
   val id : String,
    val idUser : String,
    val waktu : String,
    val text : String

){
    constructor(): this("","","","")
}


