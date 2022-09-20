package com.example.marveltrial.data.remote

import com.example.marveltrial.common.Constants
import com.example.marveltrial.data.remote.dto.CharacterDetailDto
import com.example.marveltrial.data.remote.dto.CharacterListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelAPI {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timestamp,
        @Query("hash") hash: String = Constants.hash(),
        @Query("limit") limit: Int = Constants.LIMIT
    ): CharacterListDto

    @GET("/v1/public/characters/{characterId}")
    suspend fun getCharactersbyId(
        @Path("characterId") characterId: String,
        @Query("apikey") apikey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timestamp,
        @Query("hash") hash: String = Constants.hash()
    ): CharacterDetailDto
}
