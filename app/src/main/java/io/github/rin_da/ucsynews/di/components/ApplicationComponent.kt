package io.github.rin_da.ucsynews.di.components

import android.content.Context
import dagger.Component
import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.di.modules.ApplicationModule
import io.github.rin_da.ucsynews.presentation.base.activity.BaseActivity
import javax.inject.Singleton

/**
 * Created by user on 12/13/16.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun context(): Context
    fun dataSource(): DataBaseSource
    fun inject(activity: BaseActivity)

}
