package com.example.instagram01.model

class Messenger {
    private var idMessenger: Int =0
    private var messageSender: String = "" // người gửi tin nhắn
    private var messageRecipient: String = "" //  người nhận tin nhắn


    constructor()
    constructor(idMessenger: Int, messageSender: String, messageRecipient: String) {
        this.idMessenger = idMessenger
        this.messageSender = messageSender
        this.messageRecipient = messageRecipient
    }

    public var IdMessenger: Int
        get() { return idMessenger}
        set(value) { idMessenger = value }

    public var MessageSender: String
        get() { return messageSender}
        set(value) { messageSender = value }

    public var MessageRecipient: String
        get() { return messageRecipient}
        set(value) { messageRecipient = value }

}