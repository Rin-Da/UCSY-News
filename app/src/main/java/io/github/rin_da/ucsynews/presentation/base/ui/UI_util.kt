package io.github.rin_da.ucsynews.presentation.base.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.ViewManager
import mehdi.sakout.fancybuttons.FancyButton
import org.jetbrains.anko.custom.ankoView

/**
 * Created by user on 12/4/16.
 */
var states = arrayOf(intArrayOf(android.R.attr.state_enabled), // enabled
        intArrayOf(-android.R.attr.state_enabled), // disabled
        intArrayOf(-android.R.attr.state_checked), // unchecked
        intArrayOf(android.R.attr.state_pressed)  // pressed
)

var colors = intArrayOf(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)

val cardBackgroundWhite = ColorStateList(states,colors)
public inline fun ViewManager.fontAwesome(theme: Int = 0) = fontAwesome(theme) {}
public inline fun ViewManager.fontAwesome(theme: Int = 0, init: FancyButton.() -> Unit) = ankoView({ FancyButton(it) }, theme, init)