package io.github.rin_da.ucsynews.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.data.source.DataSource
import io.github.rin_da.ucsynews.data.source.local.LocalBaseSource
import io.github.rin_da.ucsynews.data.source.local.LocalSource
import javax.inject.Singleton

/**
 * Created by user on 12/13/16.
 */
@Module
class ApplicationModule(var application: Application) {
    @Provides @Singleton fun application(): Context = application
    @Provides @Singleton fun localSource(localSource: LocalSource): LocalBaseSource = localSource
    @Provides @Singleton fun dataSource(localSource: DataSource): DataBaseSource = localSource
}
