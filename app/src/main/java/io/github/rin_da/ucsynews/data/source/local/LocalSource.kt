package io.github.rin_da.ucsynews.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

const val USER: String = "USER_KEY"

class LocalSource : LocalBaseSource {
    @Inject lateinit var sharedPref: SharedPreferences

    @Inject constructor() {


    }

    override fun getUserPreferences(): String? = sharedPref.getString(USER, null)

    override fun saveUserPreferences(uuid: String) {
        val editor = sharedPref.edit()
        editor.putString(USER, uuid)
        editor.apply()
    }

}
