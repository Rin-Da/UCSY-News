package io.github.rin_da.ucsynews.presentation.login.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ui.ResultCodes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.github.rin_da.ucsynews.presentation.base.ui.isNetworkConnected
import io.github.rin_da.ucsynews.presentation.base.view.acquireGooglePlayServices
import io.github.rin_da.ucsynews.presentation.base.view.downloadGooglePlay
import io.github.rin_da.ucsynews.presentation.login.view.LoginView
import org.jetbrains.anko.setContentView
import java.util.*

const val RC_SIGN_IN = 111
const val GOOGLE_SIGN_IN = 999


class LoginActivity : AppCompatActivity() {
    var view: LoginView = LoginView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)

        if (FirebaseAuth.getInstance().currentUser == null) {
            if (isNetworkConnected()) {
                login()
            } else {
                view.setText(getString(R.string.no_connection))
            }
        } else {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        acquireGooglePlayServices()
    }

    fun login() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder().setProviders(Arrays.asList(AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                        AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                        AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                        AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build())).setIsSmartLockEnabled(true).build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                var ref = FirebaseDatabase.getInstance().reference
                var r = ref.child("people")
                r.push().setValue(People(FirebaseAuth.getInstance().currentUser!!.uid, FirebaseAuth.getInstance().currentUser!!.displayName!!))
                finish()
                return
            }
            if (resultCode == RESULT_CANCELED) {
                finish()
                return
            }
            if (resultCode == ResultCodes.RESULT_NO_NETWORK) {
                view.setText(getString(R.string.no_connection))
                return
            }
        } else {
            downloadGooglePlay()
        }
    }

}
