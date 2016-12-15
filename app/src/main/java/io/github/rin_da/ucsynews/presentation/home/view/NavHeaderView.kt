package io.github.rin_da.ucsynews.presentation.home.view

import android.content.Context
import android.view.Gravity
import android.view.View
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.appCompatImageView
import org.jetbrains.anko.*

/**
 * Created by user on 12/15/16.
 */

class NavHeaderView : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View {
        with(ui) {

            verticalLayout(theme = R.style.ThemeOverlay_AppCompat_Dark) {
                background = context.resources.getDrawable(R.drawable.side_nav_bar)
                gravity = Gravity.CENTER
                lparams(width = matchParent, height = dimen(R.dimen.nav_header_height))
                appCompatImageView {
                    imageResource = R.drawable.ic_sad
                }.lparams(width = dimen(R.dimen.home_profile_image_dimens), height = dimen(R.dimen.home_profile_image_dimens)) {

                }
            }

        }
        return ui.view
    }
}
