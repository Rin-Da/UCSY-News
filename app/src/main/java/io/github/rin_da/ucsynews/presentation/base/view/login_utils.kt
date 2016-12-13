package io.github.rin_da.ucsynews.presentation.base.view

import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import io.github.rin_da.ucsynews.presentation.login.activity.GOOGLE_SIGN_IN

/**
 * Created by user on 12/13/16.
 */

internal fun AppCompatActivity.downloadGooglePlay() {
    val appPackageName = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE
    try {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)))
    } catch (anfe: ActivityNotFoundException) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)))
    }
}

internal fun AppCompatActivity.isGooglePlayServicesAvailable(): Boolean {
    val apiAvailability = GoogleApiAvailability.getInstance()
    val connectionStatusCode = apiAvailability.isGooglePlayServicesAvailable(this)
    return connectionStatusCode == ConnectionResult.SUCCESS
}

/**
 * Attempt to resolve a missing, out-of-date, invalid or disabled Google
 * Play Services installation via a user dialog, if possible.
 */
internal fun AppCompatActivity.acquireGooglePlayServices() {
    val apiAvailability = GoogleApiAvailability.getInstance()
    val connectionStatusCode = apiAvailability.isGooglePlayServicesAvailable(this)
    if (apiAvailability.isUserResolvableError(connectionStatusCode)) {
        showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode)
    }
}

internal fun AppCompatActivity.showGooglePlayServicesAvailabilityErrorDialog(
        connectionStatusCode: Int) {
    val apiAvailability = GoogleApiAvailability.getInstance()
    val dialog = apiAvailability.getErrorDialog(
            this,
            connectionStatusCode,
            GOOGLE_SIGN_IN, DialogInterface.OnCancelListener { v -> finish() })
    dialog.show()
}

