//import android.app.Notification
//import android.provider.SyncStateContract
//import com.example.atl_unec2.R
//import com.example.atl_unec2.sevice.Constants
//
//import android.app.PendingIntent
//import android.app.Service
//import android.content.Intent
//import android.media.MediaPlayer
//import android.os.IBinder
//import androidx.core.app.NotificationCompat
//
//class MusicPlayerService : Service() {
//
//    private val NOTIFICATION_ID = 1
//
//    private lateinit var mediaPlayer: MediaPlayer
//    private var isPlaying = false
//
//    override fun onCreate() {
//        super.onCreate()
//        mediaPlayer = MediaPlayer.create(this, R.raw.song)
//        mediaPlayer.isLooping = true
//    }
//
//    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//        Thread {
//            if (intent.action == Constants.ACTION.STARTFOREGROUND_ACTION) {
//                startForeground(NOTIFICATION_ID, createNotification())
//                playMusic()
//                isPlaying = true
//            } else if (intent.action == Constants.ACTION.STOPFOREGROUND_ACTION) {
//                stopForeground(true)
//                stopMusic()
//                isPlaying = false
//                stopSelf()
//            }
//        }
//        return START_NOT_STICKY
//    }
//
//
//    override fun onDestroy() {
//
//        super.onDestroy()
//        if (isPlaying) {
//            stopMusic()
//        }
//    }
//
//    override fun onBind(intent: Intent): IBinder? {
//        return null
//    }
//
//    private fun createNotification(): Notification {
//        val stopIntent = Intent(this, MusicPlayerService::class.java)
//        stopIntent.action = Constants.ACTION.STOPFOREGROUND_ACTION
//        val pendingStopIntent = PendingIntent.getService(this, 0, stopIntent, R.raw.)
//
//        val builder = NotificationCompat.Builder(this, Constants.NOTIFICATION_CHANNEL_ID)
//            .setContentTitle("Music Player")
//            .setContentText("Playing Music")
//            .setSmallIcon(R.drawable.baseline_home_24)
//            .addAction(R.drawable.baseline_attach_money_24, "Stop", pendingStopIntent)
//
//        return builder.build()
//    }
//
//    private fun playMusic() {
//        if (!mediaPlayer.isPlaying) {
//            mediaPlayer.start()
//        }
//    }
//
//    private fun stopMusic() {
//        if (mediaPlayer.isPlaying) {
//            mediaPlayer.pause()
//            mediaPlayer.seekTo(0)
//        }
//    }
//
//}