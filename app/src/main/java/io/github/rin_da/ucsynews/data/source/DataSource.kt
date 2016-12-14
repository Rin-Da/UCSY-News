package io.github.rin_da.ucsynews.data.source

import io.github.rin_da.ucsynews.data.source.local.LocalBaseSource
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

class DataSource : DataBaseSource {
    @Inject lateinit var localSource: LocalBaseSource

    @Inject constructor() {

    }

    override fun addUserIfExists(people: People)
            = localSource.addPeopleIfNotExists(people)

    override fun toString(): String {
        return "DataSource(localSource=$localSource)"
    }

}
