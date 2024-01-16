package com.kaylr.chat.videogamesAPI

import com.google.gson.annotations.SerializedName

class VideogamesDataResponse (
    //@SerializedName("count") val count: Integer,
    @SerializedName("results") val videogames: List<VideogamesItemResponse>

)
data class VideogamesItemResponse(
    @SerializedName("name") val name: String,
    //@SerializedName("rating") val rating: Integer,
   // @SerializedName("esrb_rating") val esrb_rating: esrbRating,
   // @SerializedName("platforms") val platforms: List<platform>,
    @SerializedName("background_image") val background_image:String?
)
data class esrbRating(
    @SerializedName("id") val id: Integer,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String
)
data class platform(
    @SerializedName("id") val id: Integer,
    @SerializedName("slug") val slug: String,
    @SerializedName("name") val name: String
)
//data class VideogamesImageResponse(@SerializedName("background_image") val background_image:String)