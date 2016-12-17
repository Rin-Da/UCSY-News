package io.github.rin_da.ucsynews.di.modules

import dagger.Module
import dagger.Provides
import io.github.rin_da.ucsynews.di.scope.ActivityScope
import io.github.rin_da.ucsynews.domain.usecase.post.PostUseCase
import io.github.rin_da.ucsynews.domain.usecase.post.base.PostBaseUseCase
import javax.inject.Named


/**
 * Created by user on 12/14/16.
 */
@Module
public class DataModule {
    var item_id = 0

    constructor(item_module: Int) {
        item_id = item_module

    }

    constructor()

    @Provides @ActivityScope @Named("post") fun post(usecase: PostUseCase): PostBaseUseCase = usecase

}
