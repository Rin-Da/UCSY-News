package io.github.rin_da.ucsynews.presentation.base.ui

import android.view.ViewManager
import mehdi.sakout.fancybuttons.FancyButton
import org.jetbrains.anko.custom.ankoView

/**
 * Created by user on 12/4/16.
 */

public inline fun ViewManager.fontAwesome(theme: Int = 0) = fontAwesome(theme) {}
public inline fun ViewManager.fontAwesome(theme: Int = 0, init: FancyButton.() -> Unit) = ankoView({ FancyButton(it) }, theme, init)