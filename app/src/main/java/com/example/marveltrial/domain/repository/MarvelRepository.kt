package com.example.marveltrial.domain.repository

import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.model.Character
import com.example.marveltrial.domain.model.CharacterDetail

interface MarvelRepository {

    suspend fun getCharacters(offset: Int): Resource<List<Character>>

    suspend fun getCharacterbyId(charId: String): Resource<CharacterDetail>
}
