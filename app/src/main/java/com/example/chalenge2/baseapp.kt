package com.example.chalenge2

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class baseapp : Application() {

    companion object{
        const val CHANEL_1_ID = "Chanel 1"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChanel()
    }

    private fun createNotificationChanel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val chanel1 = NotificationChannel(
                CHANEL_1_ID,"Chanel Satu", NotificationManager.IMPORTANCE_HIGH
            )
            chanel1.description = "ini adalah chanel 1"
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(chanel1)
        }
    }
}