package com.kaylr.chat.videogamesAPI

import com.google.gson.annotations.SerializedName
import okhttp3.internal.platform.Platform

class VideogamesDataResponse (
    //@SerializedName("count") val count: Integer,
    @SerializedName("results") val videogames: List<VideogamesItemResponse>

)
data class VideogamesItemResponse(
    //@SerializedName("id") val id: String,
    @SerializedName("name") val name: String?,
    @SerializedName("rating") val rating: Number?,
    @SerializedName("esrb_rating") val esrb_rating: EsrbRating?,
    @SerializedName("platforms") val platforms: List<VectorPlatforms>?,
    @SerializedName("background_image") val background_image:String?
)
data class EsrbRating(
    @SerializedName("id") val id: Integer?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("name") val name: String?
)
data class VectorPlatforms(
    @SerializedName("platform") val platform: platform?
)
data class platform(
    @SerializedName("id") val id: Integer?,
    @SerializedName("slug") val slug: String?,
    @SerializedName("name") val name: String?
)
//data class VideogamesImageResponse(@SerializedName("background_image") val background_image:String)