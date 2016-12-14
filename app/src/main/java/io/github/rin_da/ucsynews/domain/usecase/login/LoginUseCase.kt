package io.github.rin_da.ucsynews.domain.usecase.login

import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by user on 12/14/16.
 */
class LoginUseCase : BaseLoginUseCase {
    @Inject constructor()

    @Inject @JvmField public  var source: DataBaseSource? = null

    override fun saveUser(people: People): Completable = source!!.addUserIfExists(people)

}