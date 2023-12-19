package com.kaylr.chat.animalesAPI

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("search/{name}")
    // -> /api/7038753112847970/ delante si no va
    suspend fun getAnimals(@Path("name") animalName:String): Response<AnimalsDataResponse>
    //si usa corrutinas hay que usar "suspend"

   /* @GET("{id}")
    // -> /api/7038753112847970/ delante si no va
    suspend fun getSuperheroDetail(@Path("id") superheroId:String): Response<SuperHeroDetailResponse>*/
}