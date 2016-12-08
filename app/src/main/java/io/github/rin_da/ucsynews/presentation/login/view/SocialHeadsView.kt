package io.github.rin_da.ucsynews.presentation.login.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.colorOf
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.base.ui.intOf
import io.github.rin_da.ucsynews.presentation.base.ui.stringOf
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.linearLayout

/**
 * Created by user on 12/5/16.
 */
class SocialHeadsView : AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        linearLayout {

            fontAwesome {
                setBackgroundColor(colorOf(R.color.loginFacebookColor))
                setRadius(intOf(R.integer.login_social_heads_dimens))
                setFontIconSize(intOf(R.integer.login_social_heads_font_size));
                setIconResource(stringOf(R.string.awesome_facebook))
            }.lparams(width = dp(intOf(R.integer.login_social_heads_dimens_params)), height = dp(intOf(R.integer.login_social_heads_dimens_params))) {
                topMargin = dp(intOf(R.integer.login_social_heads_top_margin))

            }
            fontAwesome {
                setBackgroundColor(colorOf(R.color.loginGoogleColor))
                setRadius(intOf(R.integer.login_social_heads_dimens))
                setFontIconSize(intOf(R.integer.login_social_heads_font_size));
                setIconResource(stringOf(R.string.awesome_google))
            }.lparams(width = dp(intOf(R.integer.login_social_heads_dimens_params)), height = dp(intOf(R.integer.login_social_heads_dimens_params))) {
                topMargin = dp(intOf(R.integer.login_social_heads_top_margin))
                leftMargin = dp(intOf(R.integer.login_social_heads_left_margin))
            }
            fontAwesome {
                setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                setRadius(intOf(R.integer.login_social_heads_dimens))
                setFontIconSize(intOf(R.integer.login_social_heads_font_size));
                setIconResource(stringOf(R.string.awesome_sign_up))
            }.lparams(width = dp(intOf(R.integer.login_social_heads_dimens_params)), height = dp(intOf(R.integer.login_social_heads_dimens_params))) {
                topMargin = dp(intOf(R.integer.login_social_heads_top_margin))
                leftMargin = dp(intOf(R.integer.login_social_heads_left_margin))

            }
            gravity = Gravity.CENTER_HORIZONTAL

        }
    }
}