package io.github.rin_da.ucsynews

import android.app.Application
import io.github.rin_da.ucsynews.di.components.ApplicationComponent
import io.github.rin_da.ucsynews.di.components.DaggerApplicationComponent
import io.github.rin_da.ucsynews.di.modules.ApplicationModule

/**
 * Created by user on 12/4/16.
 */

class UCSYNewsApplication : Application() {
    @JvmField var applicationComponent: ApplicationComponent? = null


    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()


    }
}
