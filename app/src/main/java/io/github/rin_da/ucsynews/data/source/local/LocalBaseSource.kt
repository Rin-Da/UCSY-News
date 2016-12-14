package io.github.rin_da.ucsynews.data.source.local

import io.github.rin_da.ucsynews.data.source.base.BaseSource
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.reactivex.Completable

/**
 * Created by user on 12/13/16.
 */

abstract  class LocalBaseSource:BaseSource{

   abstract fun addUserIfNotExists(people: People):Completable
   abstract fun addPeopleIfNotExists(people: People):Completable

}
