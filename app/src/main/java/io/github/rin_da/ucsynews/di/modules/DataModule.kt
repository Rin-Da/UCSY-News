package io.github.rin_da.ucsynews.di.modules

import dagger.Module
import dagger.Provides
import io.github.rin_da.ucsynews.domain.usecase.login.BaseLoginUseCase
import io.github.rin_da.ucsynews.domain.usecase.login.LoginUseCase
import javax.inject.Named

/**
 * Created by user on 12/14/16.
 */
@Module
public  class DataModule {
    var item_id = 0

    constructor(item_module: Int) {
        item_id = item_module

    }

    @Provides @Named("login") fun loginUseCase(loginUseCase: LoginUseCase): BaseLoginUseCase {
        return loginUseCase
    }

    constructor()

}
