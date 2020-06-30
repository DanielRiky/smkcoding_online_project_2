package com.example.chalenge2

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseNotif : FirebaseMessagingService(){
    override fun onNewToken(token: String) {
       Log.d("TAG", "The token refreshed : $token")
    }
}