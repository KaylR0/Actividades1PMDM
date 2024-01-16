package com.kaylr.chat.videogamesAPI

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // no hay que poner "/" delante porque entiende que hay 2 "/"
    @GET("games?key="+VideogamesMainActivity.MY_TOKEN)
    //@Headers(VideogamesMainActivity.MY_TOKEN)
    // -> /api/7038753112847970/ delante si no va
    suspend fun getVideogames(
        @Query("search") videogamesName: String
    ): Response<VideogamesDataResponse>
    //si usa corrutinas hay que usar "suspend"

   /* @GET("{id}")
    // -> /api/7038753112847970/ delante si no va
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>*/
}