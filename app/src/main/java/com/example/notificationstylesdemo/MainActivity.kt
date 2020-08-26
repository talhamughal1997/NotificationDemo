package com.example.notificationstylesdemo


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val builder by lazy { NotificationCompat.Builder(this)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

        Handler().postDelayed({messageStyleNotification2()},6000)
    }

    fun setListeners() {
        btnNotificationActions.setOnClickListener { actionNotification() }
        btnHeadsUp.setOnClickListener {
            headUpNotification()
        }
        btnBigTextStyle.setOnClickListener { bigTextStyleNotification() }
        btnBigPictureStyle.setOnClickListener { bigPictureStyleNotification() }
        btnInboxStyle.setOnClickListener { inboxStyleNotification() }
        btnMessageStyle.setOnClickListener { messageStyleNotification() }
    }

    fun actionNotification() {
        val NOTIFICATION_ID = 1
        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        builder.setLargeIcon(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.ic_launcher_background
            )
        )
        builder.setContentTitle("Notification Actions")
        builder.setContentText("Tap View to launch google website")
        builder.setAutoCancel(true)

        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val buttonIntent = Intent(baseContext, NotificationReceiver::class.java)
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID)

        val dismissIntent = PendingIntent.getBroadcast(baseContext, 0, buttonIntent, 0)

        builder.setContentIntent(launchIntent)
        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent)
        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun headUpNotification() {
        val NOTIFICATION_ID = 2
        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        builder.setLargeIcon(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.ic_launcher_background
            )
        )
        builder.setContentTitle("Head Up Notification")
        builder.setContentText("Tap View to launch google website")
        builder.setAutoCancel(false)
        builder.setDefaults(NotificationCompat.DEFAULT_ALL)
        builder.setPriority(NotificationCompat.PRIORITY_HIGH)

        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val buttonIntent = Intent(baseContext, NotificationReceiver::class.java)
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID)

        val dismissIntent = PendingIntent.getBroadcast(baseContext, 0, buttonIntent, 0)

        builder.setContentIntent(launchIntent)
        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent)
        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun bigTextStyleNotification() {
        val NOTIFICATION_ID = 3
        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)
        builder.setLargeIcon(
            BitmapFactory.decodeResource(
                resources,
                R.drawable.ic_launcher_background
            )
        )
        builder.setContentTitle("Big Text Style Notification")
        builder.setContentText("Drag to view big text message")
        builder.setAutoCancel(true)

        builder.setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(resources.getString(R.string.lorem_ipsum))
        )

        builder.setDefaults(NotificationCompat.DEFAULT_ALL)
        builder.setPriority(NotificationCompat.PRIORITY_HIGH)

        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val buttonIntent = Intent(baseContext, NotificationReceiver::class.java)
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID)

        val dismissIntent = PendingIntent.getBroadcast(baseContext, 0, buttonIntent, 0)

        builder.setContentIntent(launchIntent)
        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent)
        builder.addAction(android.R.drawable.ic_delete, "DISMISS", dismissIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun bigPictureStyleNotification() {
        val NOTIFICATION_ID = 4

        val pic = BitmapFactory.decodeResource(resources, R.mipmap.ic_cat)

        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.mipmap.ic_cat)
        builder.color = ContextCompat.getColor(this, R.color.colorPrimaryDark)

//        builder.setLargeIcon(pic)
        builder.setContentTitle("Big Picture Style Notification")
        builder.setContentText("Drag to view big picture message")
        builder.setAutoCancel(true)
        builder.setStyle(
            NotificationCompat.BigPictureStyle().bigPicture(pic)
        )

        builder.setDefaults(NotificationCompat.DEFAULT_ALL)
        builder.setPriority(NotificationCompat.PRIORITY_HIGH)

        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val buttonIntent = Intent(baseContext, NotificationReceiver::class.java)
        buttonIntent.putExtra("notificationId", NOTIFICATION_ID)
        builder.setContentIntent(launchIntent)
        builder.addAction(android.R.drawable.ic_menu_view, "VIEW", pendingIntent)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    private fun inboxStyleNotification() {
        val NOTIFICATION_ID = 5
        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.mipmap.ic_cat)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_cat))
        builder.setStyle(
            NotificationCompat.InboxStyle().addLine("Hello").addLine("Are you there?")
                .addLine("How's your day?").setBigContentTitle("3 New Messages for you")
                .setSummaryText("Inbox")
        )
        builder.setAutoCancel(true)
        builder.setContentIntent(launchIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    private fun messageStyleNotification() {
        val NOTIFICATION_ID = 6
        val launchIntent = getLaunchIntent(NOTIFICATION_ID)
//        val builder = NotificationCompat.Builder(this)
        builder.setSmallIcon(R.mipmap.ic_cat)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_cat))
        builder.setContentTitle("Messages")
        builder.setStyle(
            NotificationCompat.MessagingStyle("Teacher").setConversationTitle("Q&A Group")
                .addMessage(
                    "This type of notification was introduced in Android N. Right?",
                    0,
                    "Student 1"
                )
                .addMessage("Yes", 0, "null")
                .addMessage(
                    "The constructor is passed with the name of the current user. Right?",
                    0,
                    "Student 2"
                )
                .addMessage("True", 0, "null")
        )
        builder.setAutoCancel(true)
        builder.setContentIntent(launchIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    private fun messageStyleNotification2() {
        val NOTIFICATION_ID = 6
        val launchIntent = getLaunchIntent(NOTIFICATION_ID)

        builder.setSmallIcon(R.mipmap.ic_cat)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_cat))
        builder.setContentTitle("Messages")
        builder.setStyle(
            NotificationCompat.MessagingStyle("Teacher Update").setConversationTitle("Q&A Group")
                .addMessage(
                    "This type of notification was introduced in Android N. Right?",
                    0,
                    "Student 1"
                )
                .addMessage("Yes", 0, "null")

        )
        builder.setAutoCancel(true)
        builder.setContentIntent(launchIntent)
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Will display the notification in the notification bar
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

}