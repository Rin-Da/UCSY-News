package io.github.rin_da.ucsynews.presentation.abstract.model

/**
 * Created by user on 12/13/16.
 */

public class People {
    var uid: String = ""
    var profile_pic: String? = null
    var userNme: String = ""

    constructor()

    constructor(uid: String, userNme: String) {
        this.uid = uid
        this.userNme = userNme
    }

}
