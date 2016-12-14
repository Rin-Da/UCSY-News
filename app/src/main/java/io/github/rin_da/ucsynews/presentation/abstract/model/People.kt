package io.github.rin_da.ucsynews.presentation.abstract.model

/**
 * Created by user on 12/13/16.
 */

public class People {
    var uid: String = ""
    var profile_pic: String? = null
    var userName: String = ""

    constructor()



    constructor(profile_pic: String? = "", uid: String, userName: String) {
        this.profile_pic = profile_pic
        this.uid = uid
        this.userName = userName
    }

}
