package com.rickmorty.corutine.api

import com.rickmorty.corutine.models.CharacterResult
import retrofit2.Response
import retrofit2.http.GET

interface Requests {
    @GET("api/character")
    suspend fun getCharacters(): Response<CharacterResult>
}