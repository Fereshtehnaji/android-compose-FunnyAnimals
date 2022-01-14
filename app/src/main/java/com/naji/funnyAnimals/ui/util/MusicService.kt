package com.naji.funnyAnimals.ui.util

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.naji.funnyAnimals.R

class MusicService : Service() {

    var mMediaPlayer: MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createPlayer(R.raw.music_back)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mMediaPlayer!!.start()
        return START_STICKY
    }

    private fun createPlayer(soundResourceId: Int) {

        if (mMediaPlayer != null) {

            try {
                mMediaPlayer!!.stop()
            } catch (e: Exception) {
            }

            mMediaPlayer!!.release()
            mMediaPlayer = null
        }

        mMediaPlayer = MediaPlayer.create(this, soundResourceId)
        mMediaPlayer!!.isLooping = true

        // if the instance could be created
        if (mMediaPlayer != null) {
            // set a listener that is called when playback has been finished
            mMediaPlayer!!.setOnCompletionListener { mp ->

                if (mp != null) {
                    mp.release()
                    mMediaPlayer = null
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mMediaPlayer?.stop()
        mMediaPlayer?.release()
        mMediaPlayer = null
    }
}