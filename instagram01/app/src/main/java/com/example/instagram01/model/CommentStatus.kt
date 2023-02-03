package com.example.instagram01.model

import java.util.*

class CommentStatus {
    private var idComment: Int = 0
    private var idStatus: Int =0
    private var userName: String = ""
    private var content: String = "" // nội dung comment
    private var cmtTime: Date = Calendar.getInstance().time // thời gian hiện tại



    constructor()
    constructor(idComment: Int, idStatus: Int, userName: String, content: String, cmtTime: Date) {
        this.idComment = idComment
        this.idStatus = idStatus
        this.userName = userName
        this.content = content
        this.cmtTime = cmtTime
    }


    public var IdComment: Int
        get() { return idComment}
        set(value) { idComment = value }

    public var IdStatus: Int
        get() { return idStatus}
        set(value) { idStatus = value }

    public var UserName: String
        get() { return UserName}
        set(value) { UserName = value }

    public var Content: String
        get() { return content}
        set(value) { content = value }

    public var CmtTime: Date
        get() { return cmtTime}
        set(value) { cmtTime = value }


}