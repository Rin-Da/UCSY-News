package io.github.rin_da.ucsynews.presentation.login.view

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.View
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.base.ui.colorOf
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.base.ui.intOf
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
                setFontIconSize(30);
                setIconResource("\uf09a")
            }.lparams(width = dp(70), height = dp(70)) {
                topMargin = dp(30)
                leftMargin = dp(45)
            }
            fontAwesome {
                setBackgroundColor(Color.parseColor("#d62a0a"))
                setRadius(intOf(R.integer.login_social_heads_dimens))
                setFontIconSize(30);
                setIconResource("\uf0d5")
            }.lparams(width = dp(70), height = dp(70)) {
                topMargin = dp(30)
                leftMargin = dp(25)
            }
            fontAwesome {
                setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                setRadius(intOf(R.integer.login_social_heads_dimens))
                setFontIconSize(30);
                setIconResource("\uf234")
            }.lparams(width = dp(70), height = dp(70)) {
                topMargin = dp(30)
                leftMargin = dp(25)

            }

        }
    }
}