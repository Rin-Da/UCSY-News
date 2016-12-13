package io.github.rin_da.ucsynews.di.components

import dagger.Component
import io.github.rin_da.ucsynews.di.modules.ActivityModule
import io.github.rin_da.ucsynews.di.scope.ActivityScope

/**
 * Created by user on 12/13/16.
 */
@ActivityScope
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent
