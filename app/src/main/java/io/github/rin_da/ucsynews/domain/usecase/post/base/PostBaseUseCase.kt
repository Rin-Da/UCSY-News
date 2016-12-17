package io.github.rin_da.ucsynews.domain.usecase.post.base

import io.github.rin_da.ucsynews.domain.usecase.BaseUseCase
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.reactivex.Completable

/**
 * Created by user on 12/16/16.
 */


abstract class PostBaseUseCase : BaseUseCase {

    abstract fun post(post: Post, uuid: String): Completable
}
