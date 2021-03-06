package io.github.rin_da.ucsynews.data.source.local

import io.github.rin_da.ucsynews.data.source.base.BaseSource
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.reactivex.Completable

/**
 * Created by user on 12/13/16.
 */

abstract class RemoteBaseSource : BaseSource {


    abstract fun addPeopleIfNotExists(people: People): Completable

    abstract fun post(post: Post,uuid:String): Completable

}
