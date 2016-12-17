package io.github.rin_da.ucsynews.domain.usecase.post

import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.domain.usecase.post.base.PostBaseUseCase
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by user on 12/16/16.
 */

public class PostUseCase : PostBaseUseCase{
    @Inject lateinit var source: DataBaseSource

    @Inject constructor():super(){

    }

    override fun post(post: Post, uuid: String): Completable
            = source.post(post, uuid)

}
