package io.github.rin_da.ucsynews.presentation.base.ui

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.TextView
import io.github.rin_da.ucsynews.presentation.Test
import mehdi.sakout.fancybuttons.FancyButton
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.resources

/**
 * Created by user on 12/4/16.
 */

const val SHOW = View.VISIBLE
const val HIDE = View.GONE
fun View.show(){
    visibility = SHOW
}

val testIntent = fun(context: Context) = Intent(context, Test::class.java)

fun View.hide(){
    visibility = HIDE
}
var states = arrayOf(intArrayOf(android.R.attr.state_enabled), // enabled
        intArrayOf(-android.R.attr.state_enabled), // disabled
        intArrayOf(-android.R.attr.state_checked), // unchecked
        intArrayOf(android.R.attr.state_pressed)  // pressed
)

fun TextView.setRegularFont() {
    this.typeface = Typeface.createFromAsset(context.assets, "fonts/AvenirNext-Medium.ttf")
}

var colors = intArrayOf(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)
fun AnkoContext<*>.colorOf(id: Int): Int = ContextCompat.getColor(this.ctx, id)
fun AnkoContext<*>.intOf(id: Int): Int = resources.getInteger(id)
fun AnkoContext<*>.stringOf(id: Int): String = resources.getString(id)

fun Context.isNetworkConnected(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()
}

fun <T : AnkoComponent<out Context>> ViewGroup.mount(component: T, onMount: (T.() -> Unit)? = null) =

        context.render(component as AnkoComponent<Context>).apply {
            addView(this)
            onMount?.invoke(component)
        }

public inline fun ViewManager.appCompatImageView(theme: Int = 0) = appCompatImageView(theme) {}
public inline fun ViewManager.appCompatImageView(theme: Int = 0, init: AppCompatImageView.() -> Unit) = ankoView({ AppCompatImageView(it) }, theme, init)

inline fun Context.render(component: AnkoComponent<out Context>): View =
        (component as AnkoComponent<Context>).createView(AnkoContext.createReusable(this))

val cardBackgroundWhite = ColorStateList(states, colors)
public inline fun ViewManager.fontAwesome(theme: Int = 0) = fontAwesome(theme) {}
public inline fun ViewManager.fontAwesome(theme: Int = 0, init: FancyButton.() -> Unit) = ankoView({ FancyButton(it) }, theme, init)