package com.rickmorty.coroutine.api

import com.rickmorty.coroutine.models.CharacterResult
import retrofit2.Response
import retrofit2.http.GET

interface Requests {
    @GET("api/character")
    suspend fun getCharacters(): Response<CharacterResult>
}