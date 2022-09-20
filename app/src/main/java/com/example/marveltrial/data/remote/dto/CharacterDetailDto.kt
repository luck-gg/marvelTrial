package com.example.marveltrial.data.remote.dto

import com.example.marveltrial.domain.model.CharacterDetail
import com.google.gson.annotations.SerializedName

data class CharacterDetailDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    @SerializedName("data")
    val characterData: Data,
    val etag: String,
    val status: String
)
fun CharacterDetailDto.toCharacterDetail(): CharacterDetail {
    val result: Result = characterData.results.first()
    return CharacterDetail(
        id = result.id,
        name = result.name,
        description = result.description,
        comics = result.comics.available,
        events = result.events.available,
        series = result.series.available,
        stories = result.stories.available,
        thumbnail = "${result.thumbnail.path}.${result.thumbnail.extension}"
    )
}
