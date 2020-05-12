package com.example.chalenge2


import com.google.gson.annotations. SerializedName
import java.io.Serializable

data class CoronaIndonesiaItem(
    @SerializedName("dirawat")
    val dirawat: String,
    @SerializedName("meninggal")
    val meninggal: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("positif")
    val positif: String,
    @SerializedName("sembuh")
    val sembuh: String

    ): Serializable
