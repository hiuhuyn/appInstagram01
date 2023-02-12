package com.example.instagram01.model

import android.net.Uri

class ImageStaus {
    private var idImage: Int = 0
    private var idStatus: Int = 0
    private lateinit var srcImg: Uri
    constructor(idImage: Int, idStatus: Int, srcImg: Uri){
        this.idImage = idImage
        this.idStatus = idStatus
        this.srcImg = srcImg
    }
    var IdImage: Int
        get() {return idImage}
        set(value) { idImage = value }
    var IdStatus: Int
        get() {return idStatus}
        set(value) { idStatus = value }
    var SrcImg: Uri
        get() {return srcImg}
        set(value) { srcImg = value }

}