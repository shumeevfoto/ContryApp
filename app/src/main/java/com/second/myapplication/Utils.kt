package com.second.myapplication

import android.graphics.Insets.add
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import java.text.NumberFormat
import java.util.*


fun languageToString(languages:List<Languages>):String{
    return languages.joinToString {it.name}
}

fun FormatNumberContry(number:Long):String{
    val result = NumberFormat.getInstance().format(number)
    return result
}

//suspend fun loadSvg(imageView: ImageView, url: String) {
//    if (url.lowercase(Locale.ENGLISH).endsWith("svg")) {
//        val imageLoader = ImageLoader.Builder(imageView.context)
//            .componentRegistry {
//                add(SvgDecoder(imageView.context))
//            }
//            .build()
//        val request = ImageRequest.Builder(imageView.context)
//            .data(url)
//            .target(imageView)
//            .build()
//        imageLoader.execute(request)
//    } else {
//        imageView.load(url)
//    }
//}



