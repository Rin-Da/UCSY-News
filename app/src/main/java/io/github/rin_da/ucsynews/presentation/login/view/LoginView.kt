package io.github.rin_da.ucsynews.presentation.login.view

import android.view.View
import io.github.rin_da.ucsynews.presentation.abstract.view.AbstractView
import io.github.rin_da.ucsynews.presentation.base.model.BaseModel
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.relativeLayout

/**
 * Created by user on 12/4/16.
 */

class LoginView : AbstractView<BaseModel>(), AnkoComponent<LoginActivity> {
    override fun createView(ui: AnkoContext<LoginActivity>): View {
        with(ui) {
            relativeLayout {
                
            }
        }
        return ui.view
    }
}
