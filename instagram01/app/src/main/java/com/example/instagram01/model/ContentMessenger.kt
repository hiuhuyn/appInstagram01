package com.example.instagram01.model

class ContentMessenger {
    private var idContent: Int = 0
    private var idMessenger: Int =0
    private var content: String = ""
//    private var sendTime


    constructor()
    constructor(idContent: Int, idMessenger: Int, content: String) {
        this.idContent = idContent
        this.idMessenger = idMessenger
        this.content = content
    }


    public var IdContent: Int
        get() { return idContent}
        set(value) { idContent = value }

    public var IdMessenger: Int
        get() { return idMessenger}
        set(value) { idMessenger = value }

    public var Content: String
        get() { return content}
        set(value) { content = value }
}