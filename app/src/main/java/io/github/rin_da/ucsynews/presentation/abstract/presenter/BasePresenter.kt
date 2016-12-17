package io.github.rin_da.ucsynews.presentation.abstract.presenter

import io.github.rin_da.ucsynews.presentation.base.presenter.IPresenter
import io.github.rin_da.ucsynews.presentation.base.view.IView
import io.github.rin_da.ucsynews.presentation.post.view.PostBaseView

/**
 * Created by user on 12/4/16.
 */

abstract class BasePresenter<T : IView> : IPresenter {
    var view: PostBaseView? = null


    abstract fun subscribe()
    abstract fun unsubscribe()

}

