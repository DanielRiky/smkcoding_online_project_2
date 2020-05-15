package com.example.chalenge2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_dzikir.*

class DzikirFragment : Fragment(){




    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dzikir,
            container, false )
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super .onViewCreated(view, savedInstanceState)

        var awal = 0

        btnplus.setOnClickListener {

            var awal = awal++
            wirit.setText(awal.toString())

        }

        btnReset.setOnClickListener {

            if ( awal == 0 ) {
                wirit.setText(awal.toString())
            } else {
                awal = 0

            }
            wirit.setText(awal.toString())
        }



    }





}