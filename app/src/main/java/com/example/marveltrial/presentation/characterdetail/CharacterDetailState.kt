package com.example.marveltrial.presentation.characterdetail

import com.example.marveltrial.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = ""
)
