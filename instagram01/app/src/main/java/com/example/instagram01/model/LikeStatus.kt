package com.example.instagram01.model

class LikeStatus {
    private var idLike: Int =0
    private var idStaus: Int =0
    private var userName: String = "" //  người like


    constructor()
    constructor(idLike: Int, idStaus: Int, userName: String) {
        this.idLike = idLike
        this.idStaus = idStaus
        this.userName = userName
    }

    public var IdLike: Int
        get() { return idLike}
        set(value) { idLike = value }

    public var IdStaus: Int
        get() { return idStaus}
        set(value) { idStaus = value }

    public var UserName: String
        get() { return userName}
        set(value) { userName = value }


}