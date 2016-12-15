package io.github.rin_da.ucsynews.presentation.home.view

import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.view.Gravity
import android.view.View
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.mount
import io.github.rin_da.ucsynews.presentation.home.activity.HomeActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.wrapContent

/**
 * Created by user on 12/15/16.
 */
class HomeView : AnkoComponent<HomeActivity> {
    lateinit var appBar: AppBarHome
    lateinit var drawer: DrawerLayout
    lateinit var nav: NavigationView
    lateinit var header: NavHeaderView
    override fun createView(ui: AnkoContext<HomeActivity>): View {
        with(ui) {
            drawer = drawerLayout {
                appBar = AppBarHome()
                mount(appBar).lparams(width = matchParent, height = matchParent)
                nav = navigationView {
                    header = NavHeaderView()
                    inflateMenu(R.menu.activity_home_drawer)

                    addHeaderView(header.createView(AnkoContext.createReusable(context)))
                    fitsSystemWindows = true
                }.lparams(width = wrapContent, height = matchParent) {
                    gravity = Gravity.START
                }
            }

        }
        return ui.view
    }
}