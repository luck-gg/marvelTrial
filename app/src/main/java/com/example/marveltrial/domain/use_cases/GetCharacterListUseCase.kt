package com.example.marveltrial.domain.use_cases

import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.model.Character
import com.example.marveltrial.domain.repository.MarvelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        val response = repository.getCharacters()
        emit(response)
    }
}