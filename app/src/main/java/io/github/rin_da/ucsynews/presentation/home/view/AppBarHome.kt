package io.github.rin_da.ucsynews.presentation.home.view

import android.content.Context
import android.support.v7.widget.Toolbar
import android.view.View
import io.github.rin_da.ucsynews.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

/**
 * Created by user on 12/15/16.
 */
class AppBarHome : AnkoComponent<Context> {
    lateinit var tb: Toolbar
        get



    override fun createView(ui: AnkoContext<Context>): View {
        with(ui) {
            coordinatorLayout {
                lparams(width = matchParent, height = matchParent)
                fitsSystemWindows = true
                appBarLayout(theme = R.style.LoginTheme_AppBarOverlay) {
                    tb = toolbar {
                        backgroundColor = R.color.colorPrimary
                        popupTheme = R.style.LoginTheme_PopupOverlay
                    }.lparams(width = matchParent, height = context.resources.getDimension(R.dimen.abc_action_bar_default_height_material).toInt())
                }.lparams(height = wrapContent, width = matchParent)
            }
        }
        return ui.view
    }

}