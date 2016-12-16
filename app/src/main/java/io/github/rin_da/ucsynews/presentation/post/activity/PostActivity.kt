package io.github.rin_da.ucsynews.presentation.post.activity

import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import io.github.rin_da.ucsynews.di.components.DaggerDataComponent
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.github.rin_da.ucsynews.presentation.base.activity.BaseActivity
import io.github.rin_da.ucsynews.presentation.post.presenter.PostPresenter
import io.github.rin_da.ucsynews.presentation.post.view.PostView
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class PostActivity : BaseActivity() {
    lateinit var postView: PostView
    @Inject lateinit var presenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerDataComponent.builder().activityModule(activity()).applicationComponent(applicationComponent).build().inject(this)
        postView = PostView(presenter)

        postView.setContentView(this)


    }

    fun post(post: Post) {
        presenter.post(post, FirebaseAuth.getInstance().currentUser!!.uid)
    }
}
