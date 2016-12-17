package io.github.rin_da.ucsynews.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.rin_da.ucsynews.presentation.post.activity.PostActivity

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(Test@this,PostActivity::class.java))
        finish()
    }
}
