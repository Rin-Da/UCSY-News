package io.github.rin_da.ucsynews.presentation.post.view

import android.content.Context
import android.view.View
import android.widget.EditText
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.github.rin_da.ucsynews.presentation.post.activity.PostActivity
import io.github.rin_da.ucsynews.presentation.post.presenter.PostPresenter
import org.jetbrains.anko.*

/**
 * Created by user on 12/16/16.
 */

class PostView(var presenter: PostPresenter) : AnkoComponent<PostActivity>, PostBaseView() {

    override fun success() {
        context.toast("Success")
    }

    override fun failed() {
        context.toast("Failed")
    }

    lateinit var mEdit: EditText
    lateinit var context: Context

    override fun createView(ui: AnkoContext<PostActivity>): View {
        context = ui.ctx
        presenter.view = this

        with(ui) {
            relativeLayout {
                mEdit = editText {

                }.lparams(width = matchParent, height = wrapContent)
                button {
                    onClick {
                        owner.post(Post(title = mEdit.text.toString(), description = mEdit.text.toString()))
                    }
                }.lparams(width = wrapContent, height = wrapContent) {
                    alignParentBottom()
                }
            }
        }
        return ui.view
    }
}