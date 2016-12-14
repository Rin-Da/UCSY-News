package io.github.rin_da.ucsynews.di.components

import dagger.Component
import io.github.rin_da.ucsynews.di.modules.ActivityModule
import io.github.rin_da.ucsynews.di.scope.ActivityScope
import io.github.rin_da.ucsynews.presentation.login.activity.LoginActivity

/**
 * Created by user on 12/14/16.
 */
@ActivityScope @Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface DataComponent : ActivityComponent {

    fun inject(loginactivity: LoginActivity)
}
