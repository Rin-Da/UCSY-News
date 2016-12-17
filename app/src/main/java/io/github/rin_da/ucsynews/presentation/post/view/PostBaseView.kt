package io.github.rin_da.ucsynews.presentation.post.view

import io.github.rin_da.ucsynews.presentation.abstract.view.BaseView

/**
 * Created by user on 12/16/16.
 */
abstract  class PostBaseView:BaseView(){
    abstract fun success()
    abstract fun failed()

}