package io.github.rin_da.ucsynews.presentation.login.activity

import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ui.ResultCodes
import com.google.firebase.auth.FirebaseAuth
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.di.components.DaggerDataComponent
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.github.rin_da.ucsynews.presentation.base.activity.BaseActivity
import io.github.rin_da.ucsynews.presentation.base.ui.isNetworkConnected
import io.github.rin_da.ucsynews.presentation.base.ui.testIntent
import io.github.rin_da.ucsynews.presentation.base.view.acquireGooglePlayServices
import io.github.rin_da.ucsynews.presentation.base.view.downloadGooglePlay
import io.github.rin_da.ucsynews.presentation.login.view.LoginView
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.setContentView
import java.util.*
import javax.inject.Inject

const val RC_SIGN_IN = 111
const val GOOGLE_SIGN_IN = 999


class LoginActivity : BaseActivity() {
    var view: LoginView = LoginView(this)
    @Inject lateinit var source: DataBaseSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)
        DaggerDataComponent.builder().activityModule(activity()).applicationComponent(applicationComponent).build().inject(this)
        if (FirebaseAuth.getInstance().currentUser == null) {
            if (isNetworkConnected()) {
                login()
            } else {
                view.setText(getString(R.string.no_connection))
            }
        } else {
            if (isNetworkConnected()) {
                source.addUserIfExists(People(uid = FirebaseAuth.getInstance().currentUser!!.uid, userName = FirebaseAuth.getInstance().currentUser!!.displayName!!)).subscribe(CompletableSubscriber())
            } else {
                go2Test()
                finish()
            }

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
                        AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build())).setIsSmartLockEnabled(false).build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                source.addUserIfExists(People(uid = FirebaseAuth.getInstance().currentUser!!.uid, userName = FirebaseAuth.getInstance().currentUser!!.displayName!!)).subscribe(CompletableSubscriber())
                return
            }
            if (resultCode == RESULT_CANCELED) {
                view.setText(getString(R.string.no_connection))
                FirebaseAuth.getInstance().signOut()
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

    fun go2Test() {
        startActivity(testIntent(this@LoginActivity))
    }

    inner class CompletableSubscriber : CompletableObserver {
        override fun onComplete() {
            go2Test()
            finish()
        }

        override fun onError(e: Throwable?) {
            view.setText(getString(R.string.no_connection))
        }

        override fun onSubscribe(d: Disposable?) {

        }
    }
}
