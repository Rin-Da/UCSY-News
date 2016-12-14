package io.github.rin_da.ucsynews.domain.usecase.login

import io.github.rin_da.ucsynews.domain.usecase.BaseUseCase
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.reactivex.Completable

/**
 * Created by user on 12/14/16.
 */

abstract  class BaseLoginUseCase:BaseUseCase{

   abstract fun saveUser(people:People):Completable

}
