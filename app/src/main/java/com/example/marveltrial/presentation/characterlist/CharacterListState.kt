package com.example.marveltrial.presentation.characterlist

import com.example.marveltrial.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
