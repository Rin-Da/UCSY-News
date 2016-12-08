package io.github.rin_da.ucsynews.presentation.login.view

import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.FrameLayout
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.R
import io.github.rin_da.ucsynews.presentation.abstract.view.AbstractView
import io.github.rin_da.ucsynews.presentation.base.model.BaseModel
import io.github.rin_da.ucsynews.presentation.base.ui.cardBackgroundWhite
import io.github.rin_da.ucsynews.presentation.base.ui.intOf
import io.github.rin_da.ucsynews.presentation.base.ui.mount
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.design.floatingActionButton

/**
 * Created by user on 12/4/16.
 */

class LoginView : AbstractView<BaseModel>(), AnkoComponent<LoginActivity> {


    override fun createView(ui: AnkoContext<LoginActivity>): View {
        val loginHead = UserHeadView()
        with(ui) {
            relativeLayout {
                mount(loginHead).
                        lparams(width = dp(intOf(R.integer.login_user_head_dimen)), height = dp(intOf(R.integer.login_user_head_dimen))) {
                            centerHorizontally()
                            topMargin = dp(intOf(R.integer.login_user_head_top_margin))
                        }
                cardView {
                    id = R.id.login_card_id
                    cardElevation = dp(intOf(R.integer.login_cardview_elevation)).toFloat()
                    cardBackgroundColor = cardBackgroundWhite
                    verticalLayout {
                        mount(SocialHeadsView()).lparams(width = matchParent, height = dp(intOf(R.integer.login_social_heads_height)))
                        textView {
                            text = "Email"
                            textSize = sp(7).toFloat()
                            textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        }.lparams(width = matchParent, height = wrapContent) {
                            topMargin = dp(40)
                            leftMargin = dp(25)

                        }
                        editText {
                            backgroundResource = R.drawable.editbackground
                            textSize = sp(6).toFloat()
                            textColor = Color.WHITE
                            setPadding(dp(10), 0, dp(10), 0)
                        }.lparams(width = matchParent, height = dp(45)) {
                            leftMargin = dp(20)
                            topMargin = dp(15)
                            rightMargin = dp(20)

                        }
                        textView {
                            text = "Password"
                            textSize = sp(7).toFloat()
                            textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        }.lparams(width = matchParent, height = wrapContent) {
                            topMargin = dp(15)
                            leftMargin = dp(25)

                        }
                        editText {
                            backgroundResource = R.drawable.editbackground
                            textSize = sp(6).toFloat()
                            textColor = Color.WHITE
                            setPadding(dp(10), 0, dp(10), 0)
                        }.lparams(width = matchParent, height = dp(45)) {
                            leftMargin = dp(20)
                            topMargin = dp(15)
                            rightMargin = dp(20)

                        }

                    }.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
                }.lparams(width = dp(350), height = dp(385)) {
                    below(R.id.login_user_view)
                    centerHorizontally()
                    topMargin = dp(45)
                }
                floatingActionButton {
                    size = FloatingActionButton.SIZE_NORMAL
                    setImageResource(R.drawable.ic_check_black_24dp)
                    setColorFilter(Color.WHITE)
                }.lparams(width = dp(64), height = dp(64)) {
                    below(R.id.login_card_id)
                    topMargin = dp(-30)
                    centerHorizontally()
                }

            }
        }
        return ui.view
    }
}
