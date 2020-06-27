package com.example.chalenge2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class MuhasabahFragment : Fragment(), View.OnClickListener{

    private lateinit var edtmuhasabah : EditText
    private lateinit var btnmuhasabah : Button
    var firebaseAuth: FirebaseAuth? = null
    private lateinit var  ref : DatabaseReference
    private lateinit var  listmhsbh : ListView
    private lateinit var muhasabahlist : MutableList<Muhasabah>



    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_muhasabah,
            container, false )



    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        ref = FirebaseDatabase.getInstance().getReference("muhasabah")
        edtmuhasabah = view.findViewById(R.id.edtmuhasabah)
        btnmuhasabah = view.findViewById(R.id.btnmuhasabah)
        listmhsbh = view.findViewById(R.id.lv_muhasabah)
        btnmuhasabah.setOnClickListener(this)

        muhasabahlist = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    muhasabahlist.clear()
                    for (h in p0.children){
                        val muhasabah = h.getValue(Muhasabah::class.java)
                        if (muhasabah != null){
                            muhasabahlist.add(muhasabah)
                        }
                    }
                    val adapter = context?.let { MuhasabahAdapter(it, R.layout.muhasabah_item,muhasabahlist) }
                    listmhsbh.adapter = adapter
                }
            }

        })
    }

    override fun onClick(p0: View?) {
        muhasabahin()
    }

    private fun muhasabahin() {

        val textmuhasbah = edtmuhasabah.text.toString().trim()

        if(textmuhasbah.isEmpty()){
            edtmuhasabah.error = "Mohon di Isi Terlebih Dahulu"
           return
        }

            var dani = firebaseAuth?.currentUser
            val mhsbhid = ref.push().key.toString()

            val idakun = dani?.uid.toString()
            val current = SimpleDateFormat("yyyy-MM-dd")
            val tanggal = current.format(Date())
            val mhsbh = Muhasabah(mhsbhid,idakun,tanggal,textmuhasbah)
            if (mhsbhid != null){
                ref.child(mhsbhid).setValue(mhsbh).addOnCompleteListener{
                    Toast.makeText(context,"Data Berhasil Di Tambahkan", Toast.LENGTH_SHORT).show()
            }
        }
        //notif()
    }

    private fun notif() {


    }





}