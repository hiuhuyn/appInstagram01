package com.example.instagram01.model

import java.util.Calendar
import java.util.Date

class Follow {
    private var idFollow: Int =0
    private var userName_followers: String = "" // người theo dõi
    private var userName_followed: String = "" //  người được theo dõi
    private var followTime: Date = Calendar.getInstance().time


    constructor()
    constructor(
        idFollow: Int,
        userName_followers: String,
        userName_followed: String,
        followTime: Date
    ) {
        this.idFollow = idFollow
        this.userName_followers = userName_followers
        this.userName_followed = userName_followed
        this.followTime = followTime
    }

    public var IdFollow: Int
        get() { return idFollow}
        set(value) { idFollow = value }

    public var UserName_followers: String
        get() { return userName_followers}
        set(value) { userName_followers = value }

    public var UserName_followed: String
        get() { return userName_followed}
        set(value) { userName_followed = value }

    public var FollowTime: Date
        get() { return followTime}
        set(value) { followTime = value }



}