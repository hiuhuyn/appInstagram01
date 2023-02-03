package com.example.instagram01.model

import java.util.Calendar
import java.util.Date

class ContentMessenger {
    private var idContent: Int = 0
    private var idMessenger: Int =0
    private var content: String = ""
    private var sendTime: Date = Calendar.getInstance().time


    constructor()
    constructor(idContent: Int, idMessenger: Int, content: String, sendTime: Date) {
        this.idContent = idContent
        this.idMessenger = idMessenger
        this.content = content
        this.sendTime = sendTime
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

    public var SendTime: Date
        get() { return sendTime}
        set(value) { sendTime = value }
}