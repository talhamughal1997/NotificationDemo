package com.example.notificationstylesdemo

import android.app.AppComponentFactory
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService


fun AppCompatActivity.getLaunchIntent(notificationId: Int): PendingIntent? {
    val intent = Intent(this, MainActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    intent.putExtra("notificationId", notificationId)
    return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
}

  fun AppCompatActivity.clearNotification() {
    val notificationId = intent.getIntExtra("notificationId", 0)
    val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
    manager!!.cancel(notificationId)
}

