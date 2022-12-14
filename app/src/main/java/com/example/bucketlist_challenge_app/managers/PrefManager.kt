package com.example.bucketlist_challenge_app.managers

import android.content.Context
import android.content.SharedPreferences
import com.example.bucketlist_challenge_app.managers.PrefManager

class PrefManager(var _context: Context) {
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor

    // shared pref mode
    var PRIVATE_MODE = 0
    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime) {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    var isFirstDbInitialization: Boolean
        get() = pref.getBoolean(IS_FIRST_INITIALIZATION, true)
        set(isFirstInitial) {
            editor.putBoolean(IS_FIRST_INITIALIZATION, isFirstInitial)
            editor.commit()
        }

    companion object {
        // Shared preferences file name
        private const val PREF_NAME = "welcome"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        private const val IS_FIRST_INITIALIZATION = "IsFirstInitialization"
    }

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}