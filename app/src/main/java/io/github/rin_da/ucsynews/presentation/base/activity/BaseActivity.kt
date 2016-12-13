package io.github.rin_da.ucsynews.presentation.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import io.github.rin_da.ucsynews.UCSYNewsApplication
import io.github.rin_da.ucsynews.di.components.ApplicationComponent

/**
 * Created by user on 12/13/16.
 */

class BaseActivity : AppCompatActivity(), IActivity {
    protected lateinit var applicationComponent: ApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        applicationComponent = (application as UCSYNewsApplication).applicationComponent!!
        applicationComponent.inject(this)

    }

}
