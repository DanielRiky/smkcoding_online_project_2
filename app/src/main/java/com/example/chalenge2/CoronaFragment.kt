package com.example.chalenge2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation. Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import data.CoronaService
import data.apiRequest
import data.httpClient
import kotlinx.android.synthetic.*

import kotlinx.android.synthetic.main.fragment_corona.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.dismissLoading
import util.showLoading
import util.tampilToast

class CoronaFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_corona,container, false )
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super .onViewCreated(view, savedInstanceState)
        callApiCoronaIndonesia()
        maps_rs.setOnClickListener { rsterdekat() }
        //corona_provinsi.setOnClickListener { fragmentprov()}

    }



    private fun rsterdekat() {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/rumah+sakit+terdekat/@-7.9378234,112.6141153,13z/data=!3m1!4b1"))
        startActivity(i)
    }

    private fun callApiCoronaIndonesia() {
        showLoading ( context !!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<CoronaService>(httpClient)
        val call = apiRequest.getUsers()
        call.enqueue( object : Callback<List<CoronaIndonesiaItem>> {
            override fun onFailure(call: Call<List<CoronaIndonesiaItem>>, t: Throwable) {
                dismissLoading (swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<CoronaIndonesiaItem>>, response:
            Response<List<CoronaIndonesiaItem>>
            ) {
                dismissLoading (swipeRefreshLayout)
                when {
                    response. isSuccessful ->
                        when {
                            response.body()?. size != 0 ->
                                tampilCoronaIndonesia(response.body()!!)
                            else -> {
                                tampilToast ( context !!, "Berhasil" )
                            }
                        }
                    else -> {
                        tampilToast ( context !!, "Gagal" )
                    }
                }
            }
        })
    }


    private fun tampilCoronaIndonesia(CoronaIndonesia: List<CoronaIndonesiaItem>) {
        listCoronaIndonesia.layoutManager = LinearLayoutManager( context )
        listCoronaIndonesia.adapter = CoronaIndonesiaAdapter( context !!, CoronaIndonesia) {
            val indonesiaSaja = it
            tampilToast(context!!, indonesiaSaja.name )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}

