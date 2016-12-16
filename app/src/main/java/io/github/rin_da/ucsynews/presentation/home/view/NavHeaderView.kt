package io.github.rin_da.ucsynews.presentation.home.view

import android.content.Context
import android.view.Gravity
import android.view.View
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.appCompatImageView
import io.github.rin_da.ucsynews.presentation.base.ui.setDemiBold
import org.jetbrains.anko.*

/**
 * Created by user on 12/15/16.
 */

class NavHeaderView : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View {
        with(ui) {

            verticalLayout(theme = R.style.ThemeOverlay_AppCompat_Dark) {
                backgroundColor = R.color.colorPrimary
                gravity = Gravity.CENTER
                lparams(width = matchParent, height = dimen(R.dimen.nav_header_height))
                appCompatImageView {
                    imageResource = R.drawable.ic_sad
                }.lparams(width = dimen(R.dimen.home_profile_image_dimens), height = dimen(R.dimen.home_profile_image_dimens)) {

                }
                textView {
                    textSize = sp(8).toFloat()
                    setDemiBold()
                    gravity = Gravity.CENTER_HORIZONTAL
                    text = "Sovalnokovia Marcida"
                }.lparams(width = dp(200), height = wrapContent) {
                    gravity = Gravity.CENTER
                    topMargin = dimen(R.dimen.activity_vertical_margin)
                    bottomPadding = dimen(R.dimen.activity_vertical_margin)
                    leftPadding = dimen(R.dimen.activity_horizontal_margin)
                }
            }

        }
        return ui.view
    }
}
