package com.example.instagram01.model

import java.util.*

class Status {
    private var idStatus: Int = 0
    private var userName: String = ""
    private var title: String = ""
    private var postTime: Date = Calendar.getInstance().time
    constructor()
    constructor(idStatus: Int, userName: String, title: String, postTime: java.util.Date) {
        this.idStatus = idStatus
        this.userName = userName
        this.title = title
        this.postTime = postTime
    }


    public var IdStatus: Int
        get() {return idStatus}
        set(value) {idStatus = value}
    public var UserName: String
        get() {return userName}
        set(value) {userName = value}
    public var Title: String
        get() {return title}
        set(value) {title = value}
    public var PostTime: Date
        get() {return postTime}
        set(value) {postTime = value}




}