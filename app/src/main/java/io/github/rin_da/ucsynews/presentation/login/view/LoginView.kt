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
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.design.floatingActionButton

/**
 * Created by user on 12/4/16.
 */

class LoginView : AbstractView<BaseModel>(), AnkoComponent<LoginActivity> {
    private val USER_VIEW_ID = 1
    private val CARD_ID = 2

    override fun createView(ui: AnkoContext<LoginActivity>): View {
        with(ui) {
            relativeLayout {
                val user_view = fontAwesome {
                    id = USER_VIEW_ID
                    setBackgroundColor(Color.parseColor("#5bffffff"))
                    setRadius(50)
                    setFontIconSize(40)
                    setIconResource("\uf007")
                }.lparams(width = dp(80), height = dp(80)) {
                    centerHorizontally()
                    topMargin = dp(60)
                }
                val card = cardView {
                    id = CARD_ID
                    cardElevation = dp(5).toFloat()
                    cardBackgroundColor = cardBackgroundWhite
                    verticalLayout {
                        linearLayout {

                            fontAwesome {
                                setBackgroundColor(Color.parseColor("#4770DD"))
                                setRadius(300)
                                setFontIconSize(30);
                                setIconResource("\uf09a")
                            }.lparams(width = dp(70), height = dp(70)) {
                                topMargin = dp(30)
                                leftMargin = dp(45)
                            }
                            fontAwesome {
                                setBackgroundColor(Color.parseColor("#d62a0a"))
                                setRadius(300)
                                setFontIconSize(30);
                                setIconResource("\uf0d5")
                            }.lparams(width = dp(70), height = dp(70)) {
                                topMargin = dp(30)
                                leftMargin = dp(25)
                            }
                            fontAwesome {
                                setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
                                setRadius(300)
                                setFontIconSize(30);
                                setIconResource("\uf234")
                            }.lparams(width = dp(70), height = dp(70)) {
                                topMargin = dp(30)
                                leftMargin = dp(25)

                            }
                        }.lparams(width = matchParent, height = dp(105)) {

                        }
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
                    below(USER_VIEW_ID)
                    centerHorizontally()
                    topMargin = dp(45)
                }

                floatingActionButton {
                    size = FloatingActionButton.SIZE_NORMAL
                    setImageResource(R.drawable.ic_check_black_24dp)

                    setColorFilter(Color.WHITE)
                }.lparams(width = dp(64), height = dp(64)) {
                    below(CARD_ID)
                    topMargin = dp(-30)
                    centerHorizontally()
                }

            }
        }
        return ui.view
    }
}
