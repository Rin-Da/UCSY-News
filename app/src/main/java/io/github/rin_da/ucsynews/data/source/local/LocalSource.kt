package io.github.rin_da.ucsynews.data.source.local

import com.google.firebase.database.*
import com.pawegio.kandroid.e
import io.github.rin_da.ucsynews.data.PEOPLE
import io.github.rin_da.ucsynews.data.addEvent
import io.github.rin_da.ucsynews.data.isValueExists
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

class LocalSource : LocalBaseSource {

    @Inject constructor() {


    }


    override fun addPeopleIfNotExists(people: People): Completable {
        val ref = FirebaseDatabase.getInstance().reference.child(PEOPLE).child(people.uid)
        return isValueExists(ref, people).flatMapCompletable { boolean ->
            e {
                "-----------_>" + boolean
            }
            if (boolean) {
                return@flatMapCompletable Completable.create { e -> e.onComplete() }
            } else {
                return@flatMapCompletable addEvent(query = ref, value = people)
            }
        }
    }

    override fun addUserIfNotExists(people: People): Completable {
        val ref = FirebaseDatabase.getInstance().reference.child(PEOPLE).child(people.uid)
        var v: ValueEventListener? = null
        return Completable.create({ emitter ->
            v = object : ValueEventListener {
                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.getValue(People::class.java) != null) {
                        emitter.onComplete()
                    } else {
                        FirebaseDatabase.getInstance().reference.child(PEOPLE).child(people.uid).setValue(people, DatabaseReference.CompletionListener { databaseError, databaseReference ->
                            if (databaseError != null) {
                                emitter.onError(databaseError.toException())
                            } else {
                                emitter.onComplete()
                            }
                        })
                    }
                }

                override fun onCancelled(p0: DatabaseError?) {
                    emitter.onError(p0!!.toException())
                }
            }
            ref.addListenerForSingleValueEvent(v)
        }).doOnComplete {
            ref.removeEventListener(v)
        }
    }
}
