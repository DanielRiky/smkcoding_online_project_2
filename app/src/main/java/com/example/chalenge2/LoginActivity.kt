package com.example.chalenge2

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class LoginActivity : AppCompatActivity() {

    var firebaseAuth: FirebaseAuth? = null
    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        callbackManager = CallbackManager.Factory.create()

        if (firebaseAuth!!.currentUser == null) {
        } else {
            //Jika sudah login langsung dilempar ke MainActivity
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        //printkeyhash()
        loginbtn.setReadPermissions("email")
        loginbtn.setOnClickListener {
            signIn()
        }
    }

    private fun printkeyhash() {
        try {
            val info = packageManager.getPackageInfo("com.example.chalenge2",PackageManager.GET_SIGNATURES)
            for (signature in info.signatures)
            {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }

    private fun signIn() {
        loginbtn.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
                handleFacebookAccessToken(result!!.accessToken)
            }

            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException?) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun handleFacebookAccessToken(accessToken: AccessToken?) {
        val credential = FacebookAuthProvider.getCredential(accessToken!!.token)
        firebaseAuth!!.signInWithCredential(credential)
            .addOnFailureListener { e ->
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                Log.e("ERROR_EDMT",e.message)
            }
            .addOnSuccessListener { result ->

                Toast.makeText(this, "Kamu Masuk Dengan Email :  ", Toast.LENGTH_LONG)
                    .show()
                intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager!!.onActivityResult(requestCode,resultCode,data)

    }

}