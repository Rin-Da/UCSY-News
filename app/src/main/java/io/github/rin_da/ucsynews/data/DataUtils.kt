package io.github.rin_da.ucsynews.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter

/**
 * Created by user on 12/13/16.
 */
const val PEOPLE = "people"
const val POST = "post"
const val USERS = "users"

fun addEvent(query: DatabaseReference, value: Any): Completable {
    return Completable.create { emitter ->
        query.setValue(value).addOnCompleteListener { event ->
            emitter.onComplete()
        }.addOnSuccessListener { success ->
            emitter.onComplete()
        }.addOnFailureListener { event ->
            emitter.onError(event.cause)
        }
    }
}

fun isValueExists(query: DatabaseReference, value: Any): Flowable<Boolean> {
    var v: ValueEventListener? = null
    return Flowable.create({ emitter: FlowableEmitter<Boolean> ->
        v = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                emitter.onNext(false)
                emitter.onComplete()
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.getValue(Any::class.java) == null) {
                    emitter.onNext(true)

                    emitter.onComplete()
                } else {
                    emitter.onNext(false)
                    emitter.onComplete()
                }
            }
        }
        query.addValueEventListener(v)
    }, BackpressureStrategy.BUFFER).doAfterNext { value ->

        query.removeEventListener(v)

    }
}

class DataUtils {


}
