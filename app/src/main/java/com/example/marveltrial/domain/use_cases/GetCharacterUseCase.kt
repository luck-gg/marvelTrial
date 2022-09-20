package com.example.marveltrial.domain.use_cases

import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.model.CharacterDetail
import com.example.marveltrial.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(characterId: String): Flow<Resource<CharacterDetail>> = flow {
        val response = repository.getCharacterbyId(characterId)
        emit(response)
    }
}
