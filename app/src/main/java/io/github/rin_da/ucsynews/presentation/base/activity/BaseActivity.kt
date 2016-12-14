package io.github.rin_da.ucsynews.presentation.base.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.rin_da.ucsynews.UCSYNewsApplication
import io.github.rin_da.ucsynews.data.source.DataBaseSource
import io.github.rin_da.ucsynews.di.components.ApplicationComponent
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

open class BaseActivity : AppCompatActivity(), IActivity {
    protected lateinit var applicationComponent: ApplicationComponent
    @Inject lateinit var source: DataBaseSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applicationComponent = (application as UCSYNewsApplication).applicationComponent!!
        applicationComponent.inject(this)
    }


}
