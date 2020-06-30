package com.example.chalenge2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {


    lateinit var listTeman : ArrayList<Fitur>
    private fun dataFitur() {
        listTeman =ArrayList()
        listTeman.add(Fitur("Data Covid-19","Menampilkan data mengenai covid-19 baik di dunia maupun di Indonesia"))
        listTeman.add(Fitur("Waktu Shalat","Menampilkan informasi berupa waktu shalat kota Malang dan sekitarnya"))
        listTeman.add(Fitur("Dzikir","Diharapkan fitur ini dapat membantu pengguna untuk melakukan dzikir"))
        listTeman.add(Fitur("Donasi","Fitur ini akan mengarahkan kita ke website kitabisa.com"))
        listTeman.add(Fitur("Muhasabah","Di fitur ini kita dapat mengisikan apa yang telah kita lakukan hari ini dan akan tersimpan ke database realtime"))
    }



    private fun tampilTeman() {
        rv_listMyFriends. layoutManager = LinearLayoutManager( this)
        rv_listMyFriends. adapter = AboutAdapter( this !!,listTeman )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val teks:String = "Aplikasi ini dibuat untuk membantu menjlani aktivitas selama ramadhan di musim pandemi seperti saat ini."
        abouttext.setText(teks)
        dataFitur()
        tampilTeman()

        back.setOnClickListener { kembali() }
    }

    private fun kembali(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
