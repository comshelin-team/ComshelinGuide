package com.comshelin.comshelinguide

import android.graphics.Bitmap
import java.io.Serializable

data class Restaurant(val name: String, val location: String, val comment: String, val image: ByteArray) : Serializable