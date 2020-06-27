package com.example.chalenge2

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MuhasabahAdapter(val mCtx: Context, val layoutResId: Int, val muhasabahlist: List<Muhasabah> )
    : ArrayAdapter<Muhasabah>(mCtx,layoutResId,muhasabahlist)  {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layoutInflater.inflate(layoutResId, null)

        val tvtanggal : TextView = view.findViewById(R.id.tv_tanggal)
        val tvtext : TextView = view.findViewById(R.id.tv_text)
        val tvedit : TextView = view.findViewById(R.id.tv_edit)
        val muhasabah = muhasabahlist[position]
        tvedit.setOnClickListener{
            showUpdateDialog(muhasabah)
        }


        tvtanggal.text = muhasabah.waktu
        tvtext.text = muhasabah.text

        return view
    }

    fun showUpdateDialog(muhasabah: Muhasabah) {
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Edit Data")
        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.update_dialog,null)

        val etmuhasabah = view.findViewById<EditText>(R.id.edtmuhasabah)

        etmuhasabah.setText(muhasabah.text)



        builder.setView(view)

        builder.setPositiveButton("Update"){p0,p1 ->
            val dbMhsbh = FirebaseDatabase.getInstance().getReference("muhasabah")
            val text = etmuhasabah.text.toString().trim()
            if(text.isEmpty()){
                etmuhasabah.error = "Tidak Boleh Kosong"
                etmuhasabah.requestFocus()
                return@setPositiveButton
            }
            val upmuhasabah = Muhasabah(muhasabah.id, muhasabah.idUser, muhasabah.waktu, text)
            dbMhsbh.child(muhasabah.id!!).setValue(upmuhasabah)
            Toast.makeText(mCtx,"Data Berhasil Di Update", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Kembali"){p0,p1 ->

        }

        builder.setNegativeButton("Hapus"){p0,p1 ->
            val dbMhsbh = FirebaseDatabase.getInstance().getReference("muhasabah").child(muhasabah.id)

            dbMhsbh.removeValue()
            Toast.makeText(mCtx,"Data Berhasil Di Hapus", Toast.LENGTH_SHORT).show()


        }

        val alert = builder.create()
        alert.show()
    }


}