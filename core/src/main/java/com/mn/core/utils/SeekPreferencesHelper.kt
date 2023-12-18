package com.mn.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.mn.core.constants.SeekConstants

class SeekPreferencesHelper(
    context: Context
) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SeekConstants.MY_PREFS, 0)

    private val editor = sharedPreferences.edit()

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, "")
    }
}