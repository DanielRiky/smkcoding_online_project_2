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
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_dzikir.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_user.*

class UserFragment : Fragment(){




    override fun onCreate(savedInstanceState: Bundle?) {
        super .onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user,
            container, false )
    }
    override fun onViewCreated(
        view: View,
        @Nullable savedInstanceState: Bundle?
    ) {
        super .onViewCreated(view, savedInstanceState)

        logoutbtn.setOnClickListener { signOut() }
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }



}