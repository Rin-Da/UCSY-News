package io.github.rin_da.ucsynews.presentation.login.view

import android.graphics.Color
import android.view.View
import com.pawegio.kandroid.dp
import io.github.rin_da.ucsynews.presentation.abstract.view.AbstractView
import io.github.rin_da.ucsynews.presentation.base.model.BaseModel
import io.github.rin_da.ucsynews.presentation.base.ui.fontAwesome
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.centerHorizontally
import org.jetbrains.anko.relativeLayout

/**
 * Created by user on 12/4/16.
 */

class LoginView : AbstractView<BaseModel>(), AnkoComponent<LoginActivity> {
    override fun createView(ui: AnkoContext<LoginActivity>): View {
        with(ui) {
            relativeLayout {
                fontAwesome {
                    setBackgroundColor(Color.parseColor("#5bffffff"))
                    setRadius(100)
                    setFontIconSize(60);
                    setIconResource("\uf007")
                }.lparams(width = dp(100), height = dp(100)) {
                    centerHorizontally()
                    topMargin = dp(80)
                }
            }
        }
        return ui.view
    }
}
