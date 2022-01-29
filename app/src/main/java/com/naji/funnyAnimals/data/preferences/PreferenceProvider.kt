package com.naji.funnyAnimals.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

private const val KEY_BACK_MUSIC_STATUS = "back_music_status"
private const val KEY_LANGUAGE_STATUS = "language_status"

class PreferenceProvider(val context: Context) {
    private val appContext = context.applicationContext

    private val sharedPreferences: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun saveMusicBackgroundStatus(status: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_BACK_MUSIC_STATUS, status).apply()
    }

    fun getMusicBackgroundStatus(): Boolean {
        return sharedPreferences.getBoolean(KEY_BACK_MUSIC_STATUS, true)
    }

    fun saveLanguageStatus(name: String) {
        sharedPreferences.edit().putString(KEY_LANGUAGE_STATUS, name).apply()
    }

    fun getLanguageStatus(): String {
        return sharedPreferences.getString(KEY_LANGUAGE_STATUS, "fa")!!
    }
}