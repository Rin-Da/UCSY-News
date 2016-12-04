package io.github.rin_da.ucsynews.presentation.login.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.presentation.abstract.view.AbstractView
import io.github.rin_da.ucsynews.presentation.base.model.BaseModel
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by user on 12/4/16.
 */

class LoginView : AbstractView<BaseModel>(), AnkoComponent<LoginActivity> {
    private val USER_VIEW_ID = 1
    var states = arrayOf(intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(-android.R.attr.state_enabled), // disabled
            intArrayOf(-android.R.attr.state_checked), // unchecked
            intArrayOf(android.R.attr.state_pressed)  // pressed
    )

    var colors = intArrayOf(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)

    override fun createView(ui: AnkoContext<LoginActivity>): View {
        with(ui) {
            relativeLayout {
                val user_view = fontAwesome {
                    id = USER_VIEW_ID
                    setBackgroundColor(Color.parseColor("#5bffffff"))
                    setRadius(100)
                    setFontIconSize(60);
                    setIconResource("\uf007")
                }.lparams(width = dp(100), height = dp(100)) {
                    centerHorizontally()
                    topMargin = dp(80)
                }
                val card = cardView {
                    cardBackgroundColor = ColorStateList(states, colors)
                    verticalLayout {

                    }
                }.lparams(width = dp(300), height = dp(375)) {
                    below(USER_VIEW_ID)
                    centerHorizontally()
                    topMargin = dp(25)
                }
            }
        }
        return ui.view
    }
}
