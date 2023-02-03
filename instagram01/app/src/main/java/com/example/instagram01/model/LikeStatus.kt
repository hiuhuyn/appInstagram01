package com.example.instagram01.model

import java.util.Calendar
import java.util.Date

class LikeStatus {
    private var idLike: Int =0
    private var idStaus: Int =0
    private var userName: String = "" //  người like
    private var likeTime: Date = Calendar.getInstance().time


    constructor()
    constructor(idLike: Int, idStaus: Int, userName: String, likeTime: Date) {
        this.idLike = idLike
        this.idStaus = idStaus
        this.userName = userName
        this.likeTime = likeTime
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

    public var LikeTime: Date
        get() { return likeTime}
        set(value) { likeTime = value }


}