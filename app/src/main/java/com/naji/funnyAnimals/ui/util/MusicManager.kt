package com.naji.funnyAnimals.ui.util

import android.content.Context
import android.media.MediaPlayer


class MusicManager private constructor(context: Context) {
    private val context:Context=context
    init {

    }


    private var mMediaPlayer: MediaPlayer? = null

    companion object : SingletonHolder<MusicManager, Context>(::MusicManager)


    /**
     * Plays the sound with the given resource ID
     *
     * @param context a valid `Context` reference
     * @param soundResourceId the resource ID of the sound (e.g. `R.raw.my_sound`)
     */
    @Synchronized
    fun play( soundResourceId: Int) {
        // if there's an existing stream playing already
        if (mMediaPlayer != null) {
            // stop the stream in case it's still playing
            try {
                mMediaPlayer!!.stop()
            } catch (e: Exception) {
            }

            // release the resources
            mMediaPlayer!!.release()

            // unset the reference
            mMediaPlayer = null
        }

        // create a new stream for the sound to play
        mMediaPlayer = MediaPlayer.create(context, soundResourceId)

        // if the instance could be created
        if (mMediaPlayer != null) {
            // set a listener that is called when playback has been finished
            mMediaPlayer!!.setOnCompletionListener { mp ->
                // if the instance is set
                if (mp != null) {
                    // release the resources
                    mp.release()

                    // unset the reference
                    mMediaPlayer = null
                }
            }

            // start playback
            mMediaPlayer!!.start()
        }
    }

    @Synchronized
    fun stop() {
        if (mMediaPlayer != null) {
            // stop the stream in case it's still playing
            try {
                mMediaPlayer!!.stop()
            } catch (e: Exception) {
            }

            mMediaPlayer!!.release()
            mMediaPlayer = null
        }


    }
}