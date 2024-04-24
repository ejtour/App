package com.jz.app

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannerWithDefNPEField(
    @Json(name = "desc")
    val desc: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "imagePath")
    val imagePath: String,
    @Json(name = "isVisible")
    val isVisible: Int,
    @Json(name = "order")
    val order: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: Int,
    @Json(name = "url")
    val url: String,

    @Json(name = "npeNameItsTestField")  //差异在这里，没有这个值
    val npeNullAbleWithDef: String? = "It is Default Value",

)
