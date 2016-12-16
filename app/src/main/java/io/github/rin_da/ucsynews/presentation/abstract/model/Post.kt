package io.github.rin_da.ucsynews.presentation.abstract.model

import com.google.firebase.database.ServerValue

/**
 * Created by user on 12/16/16.
 */
public class Post {
    var description: String = ""
    var title: String? = null
    var time_stamp = ServerValue.TIMESTAMP

    constructor()

    constructor(title: String? = "", description: String, timestamp: Map<String, String> = ServerValue.TIMESTAMP) {
        this.description = description
        this.title = title
    }

}