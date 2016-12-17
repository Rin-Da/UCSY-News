package io.github.rin_da.ucsynews.presentation.login.view

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.*
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.*

/**
 * Created by user on 12/4/16.
 */

class LoginView(var ankoActivity: LoginActivity) : AnkoComponent<LoginActivity> {


    lateinit var error_text: TextView
    lateinit var container: ViewGroup
    lateinit var progress: ProgressBar
    var loading = true

    override fun createView(ui: AnkoContext<LoginActivity>): View {
        with(ui) {
            frameLayout {

                container = verticalLayout {
                    gravity = Gravity.CENTER
                    visibility = if (loading) {
                        View.GONE
                    } else {
                        View.VISIBLE
                    }
                    appCompatImageView {
                        imageResource = R.drawable.ic_sad
                        setColorFilter(colorOf(R.color.yellow))
                    }.lparams(width = dp(intOf(R.integer.login_error_dimens)), height = dp(intOf(R.integer.login_error_dimens))) {

                    }
                    error_text = textView {
                        setRegularFont()
                        gravity = Gravity.CENTER
                        setTextColor(colorOf(android.R.color.white))
                    }.lparams(width = dp(intOf(R.integer.login_error_text_width)), height = wrapContent) {
                        topMargin = dp(intOf(R.integer.login_error_text_margin))
                    }
                    setOnClickListener {
                        showProgress()
                        hideContainer()
                        ankoActivity.login()
                    }
                }
                progress = progressBar {
                    visibility = if (loading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }.lparams(width = wrapContent, height = wrapContent) {
                    gravity = Gravity.CENTER
                }
            }
        }
        return ui.view
    }

    fun setText(string: String) {
        error_text.text = string
        loading = false
        hideProgress()
        showContainer()
    }

    fun showContainer() {
        container.show()
    }

    fun hideContainer() {
        container.hide()
    }

    fun showProgress() {
        progress.show()
    }

    fun hideProgress() {
        progress.hide()
    }
}
