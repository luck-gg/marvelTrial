package com.example.marveltrial.data.remote.dto

import com.example.marveltrial.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterListDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @SerializedName("data")
    val characterData: Data,
    val etag: String,
    val status: String
)

fun CharacterListDto.toCharacterList(): List<Character> {
    return characterData.results.map {
        Character(
            id = it.id,
            name = it.name
        )
    }
}