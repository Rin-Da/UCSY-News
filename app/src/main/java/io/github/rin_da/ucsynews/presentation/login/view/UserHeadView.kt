package io.github.rin_da.ucsynews.presentation.login.view

import android.content.Context
import android.view.View
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.colorOf
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.base.ui.intOf
import io.github.rin_da.ucsynews.presentation.base.ui.stringOf
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by user on 12/5/16.
 */
class UserHeadView : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View = with(ui){
        fontAwesome {
            id = R.id.login_user_view
            setBackgroundColor(colorOf(R.color.loginUserHeadColor))
            setRadius(intOf(R.integer.login_user_head_radius))
            setFontIconSize(intOf(R.integer.login_user_head_font_icon_size))
            setIconResource(stringOf(R.string.login_user_head))
        }
    }
}