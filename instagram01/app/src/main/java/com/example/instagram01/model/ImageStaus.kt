package com.example.instagram01.model

class ImageStaus {
    private var idImage: Int = 0
    private var idStatus: Int = 0
    private var srcImg: Int = 0
    constructor(idImage: Int, idStatus: Int, srcImg: Int){
        this.idImage = idImage
        this.idStatus = idStatus
        this.srcImg = srcImg
    }
    constructor()
    public var IdImage: Int
        get() {return idImage}
        set(value) { idImage = value }
    public var IdStatus: Int
        get() {return idStatus}
        set(value) { idStatus = value }
    public var SrcImg: Int
        get() {return srcImg}
        set(value) { srcImg = value }

}