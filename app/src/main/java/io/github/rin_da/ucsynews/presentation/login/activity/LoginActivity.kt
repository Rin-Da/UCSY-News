package io.github.rin_da.ucsynews.presentation.login.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.rin_da.ucsynews.presentation.login.view.LoginView
import org.jetbrains.anko.setContentView

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginView().setContentView(this)
    }
}
