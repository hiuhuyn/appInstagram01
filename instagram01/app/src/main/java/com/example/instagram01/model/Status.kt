package com.example.instagram01.model

import java.sql.Date
import java.util.Calendar

class Status {
    private var idStatus: Int = 0
    private var idUser: String = ""
    private var title: String = ""
//    private var date:Calendar = Calendar.getInstance()
    constructor()
//    constructor(idStatus: Int, idUser: String, title: String, date:Calendar ){
//        this.idStatus = idStatus
//        this.idUser = idUser
//        this.title = title
//        this.date = date
//    }
    constructor(idStatus: Int, idUser: String, title: String ){
        this.idStatus = idStatus
        this.idUser = idUser
        this.title = title
    }
    public var IdStatus: Int
        get() {return idStatus}
        set(value) {idStatus = value}
    public var IdUser: String
        get() {return idUser}
        set(value) {idUser = value}
    public var Title: String
        get() {return title}
        set(value) {title = value}
//    public var Date: Calendar
//        get() {return date}
//        set(value) {date = value}




}