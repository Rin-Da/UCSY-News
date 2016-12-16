package io.github.rin_da.ucsynews.data.source

import io.github.rin_da.ucsynews.data.source.base.BaseSource
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.reactivex.Completable

/**
 * Created by user on 12/13/16.
 */

abstract  class DataBaseSource:BaseSource{
    abstract fun addUserIfExists(people: People):Completable
    abstract fun post(post:Post,uuid:String):Completable
}
