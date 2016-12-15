package io.github.rin_da.ucsynews.data.source.local

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import io.github.rin_da.ucsynews.data.PEOPLE
import io.github.rin_da.ucsynews.data.addEvent
import io.github.rin_da.ucsynews.data.isValueExists
import io.github.rin_da.ucsynews.presentation.abstract.model.People
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by user on 12/13/16.
 */

class RemoteSource : RemoteBaseSource {

    @Inject constructor() {


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
