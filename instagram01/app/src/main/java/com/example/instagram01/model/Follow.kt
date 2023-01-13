package com.example.instagram01.model

class Follow {
    private var idFollow: Int =0
    private var userName_followers: String = "" // người theo dõi
    private var userName_followed: String = "" //  người được theo dõi

    constructor(idFollow: Int, userName_followers: String, userName_followed: String) {
        this.idFollow = idFollow
        this.userName_followers = userName_followers
        this.userName_followed = userName_followed
    }
    constructor()

    public var IdFollow: Int
        get() { return idFollow}
        set(value) { idFollow = value }

    public var UserName_followers: String
        get() { return userName_followers}
        set(value) { userName_followers = value }

    public var UserName_followed: String
        get() { return userName_followed}
        set(value) { userName_followed = value }



}