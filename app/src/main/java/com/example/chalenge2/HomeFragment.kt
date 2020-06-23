package com.example.chalenge2
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation. Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import coronaNegaraItem
import data.NegaraService
import data.apiRequest
import data.httpClient
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import util.dismissLoading
import util.showLoading
import util.tampilToast

class HomeFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,
            container, false )
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super .onViewCreated(view, savedInstanceState)
        callApiCoronaNegara()
        donasi.setOnClickListener { donasi() }
        about.setOnClickListener { about() }

    }

    private fun about(){
        val intent = Intent(context, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun donasi() {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://kitabisa.com/pilihan-kitabisa"))
        startActivity(i)
    }


    private fun callApiCoronaNegara() {
        showLoading ( context !!, swipeRefreshLayoutnew)
        val httpClient = httpClient()
        val apiRequest = apiRequest<NegaraService>(httpClient)
        val call = apiRequest.getNegara()
        call.enqueue( object : Callback<List<coronaNegaraItem>> {
            override fun onFailure(call: Call<List<coronaNegaraItem>>, t: Throwable) {
                dismissLoading (swipeRefreshLayoutnew)
            }
            override fun onResponse(call: Call<List<coronaNegaraItem>>, response:
            Response<List<coronaNegaraItem>>
            ) {
                dismissLoading (swipeRefreshLayoutnew)
                when {
                    response. isSuccessful ->
                        when {
                            response.body()?. size != 0 ->
                                tampilCoronaNegara(response.body()!!)
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





    private fun tampilCoronaNegara(coronaNegara: List<coronaNegaraItem>) {
        listCoronaDunia.layoutManager = LinearLayoutManager( context )
        listCoronaDunia.adapter = CoronaDuniaAdapter( context !!, coronaNegara) {
            val negara = it
            tampilToast(context!!, negara.attributesss.countryRegion)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }




}