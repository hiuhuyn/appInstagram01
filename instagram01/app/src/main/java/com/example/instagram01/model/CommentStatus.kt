package com.example.instagram01.model

class CommentStatus {
    private var idComment: Int = 0
    private var idStatus: Int =0
    private var userName: String = ""
    private var content: String = "" // nội dung comment
//    private var cmtTime: Date



    constructor()
    constructor(idComment: Int, idStatus: Int, userName: String, content: String) {
        this.idComment = idComment
        this.idStatus = idStatus
        this.userName = userName
        this.content = content
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


}