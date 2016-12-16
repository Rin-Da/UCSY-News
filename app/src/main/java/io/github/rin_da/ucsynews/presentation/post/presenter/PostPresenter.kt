package io.github.rin_da.ucsynews.presentation.post.presenter

import io.github.rin_da.ucsynews.domain.usecase.post.base.PostBaseUseCase
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.github.rin_da.ucsynews.presentation.abstract.presenter.BasePresenter
import io.github.rin_da.ucsynews.presentation.post.view.PostBaseView
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by user on 12/16/16.
 */

class PostPresenter : BasePresenter<PostBaseView> {
    val usecase: PostBaseUseCase


    @Inject constructor(@Named("post") useCase: PostBaseUseCase) : super() {
        this.usecase = useCase
    }

    override fun subscribe() {

    }




    fun post(post: Post, uid: String) {
        usecase.post(post, uid).subscribe({
            view!!.success()
        }, { e ->
            view!!.failed()
        })
    }

    override fun unsubscribe() {

    }
}
