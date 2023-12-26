package com.example.findpairgame.model

import java.util.*

class PictureModel(
    var char: Int,
    var isVisible: Boolean = true,
    var isSelect: Boolean = false,
    var id: String = UUID.randomUUID().toString(),
) {}