package io.github.rin_da.ucsynews.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import io.github.rin_da.ucsynews.di.scope.ActivityScope

/**
 * Created by user on 12/13/16.
 */
@ActivityScope @Module
public class ActivityModule(var activity:Activity){


    @Provides @ActivityScope fun getActivitiy(): Activity {
        return activity
    }

}

