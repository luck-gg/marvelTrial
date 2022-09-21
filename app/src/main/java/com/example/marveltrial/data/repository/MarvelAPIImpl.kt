package com.example.marveltrial.data.repository

import com.example.marveltrial.common.Resource
import com.example.marveltrial.data.remote.MarvelAPI
import com.example.marveltrial.data.remote.dto.toCharacterDetail
import com.example.marveltrial.data.remote.dto.toCharacterList
import com.example.marveltrial.domain.model.Character
import com.example.marveltrial.domain.model.CharacterDetail
import com.example.marveltrial.domain.repository.MarvelRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MarvelAPIImpl @Inject constructor(
    private val api: MarvelAPI
) : MarvelRepository {

    override suspend fun getCharacters(offset: Int): Resource<List<Character>> {
        return try {
            val chars = api.getCharacters(offset = offset)
            val charList = chars.toCharacterList()
            Resource.Success(charList)
        } catch (e: HttpException) {
            Resource.Error<List<Character>>(e.localizedMessage ?: "Hubo un error inesperado")
        } catch (e: IOException) {
            Resource.Error<List<Character>>(e.localizedMessage ?: "Hubo un error inesperado")
        }
    }

    override suspend fun getCharacterbyId(charId: String): Resource<CharacterDetail> {
        return try {
            val character = api.getCharactersbyId(charId).toCharacterDetail()
            Resource.Success(character)
        } catch (e: HttpException) {
            Resource.Error<CharacterDetail>(e.localizedMessage ?: "Hubo un error inesperado")
        } catch (e: IOException) {
            Resource.Error<CharacterDetail>(e.localizedMessage ?: "Hubo un error inesperado")
        }
    }
}
