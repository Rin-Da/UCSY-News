package io.github.rin_da.ucsynews.data.source.local

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.pawegio.kandroid.e
import io.github.rin_da.ucsynews.data.PEOPLE
import io.github.rin_da.ucsynews.data.POST
import io.github.rin_da.ucsynews.data.addEvent
import io.github.rin_da.ucsynews.data.isValueExists
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.github.rin_da.ucsynews.presentation.abstract.model.Post
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

class RemoteSource : RemoteBaseSource {

    @Inject constructor() {


    }

    override fun post(post: Post, uuid: String): Completable {
        return Completable.create { emitter ->
            val postRef = FirebaseDatabase.getInstance().reference.child(POST).push()
            val peoplePost = FirebaseDatabase.getInstance().reference.child(PEOPLE).child(uuid)
            val key = postRef.key
            val postmap = mutableMapOf<String, Any>()
            postmap[POST + "/" + key] = post
            postmap["$PEOPLE/$uuid/post/$key"] = true
            e {
                postmap.toString()
            }
            FirebaseDatabase.getInstance().reference.updateChildren(postmap, DatabaseReference.CompletionListener { databaseError, databaseReference ->
                if (databaseError != null) {
                    if (databaseError.toException() != null) {
                        emitter.onError(databaseError.toException())
                    }
                } else {
                    emitter.onComplete()
                }
            })
        }
    }

    override fun addPeopleIfNotExists(people: People): Completable {
        val ref = FirebaseDatabase.getInstance().reference.child(PEOPLE).child(people.uid)
        return isValueExists(ref, people).flatMapCompletable { boolean ->
            Log.d("data", boolean.toString())
            if (boolean) {
                return@flatMapCompletable Completable.create { e -> e.onComplete() }
            } else {
                return@flatMapCompletable addEvent(query = ref, value = people)
            }
        }
    }

}
