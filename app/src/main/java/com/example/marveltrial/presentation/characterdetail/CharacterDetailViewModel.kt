package com.example.marveltrial.presentation.characterdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltrial.common.Constants
import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.use_cases.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailState())
    val state: State<CharacterDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_CHAR_ID)?.let { charId ->
            getCharacter(charId)
        }
    }

    private fun getCharacter(characterId: String) {
        getCharacterUseCase(characterId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailState(character = result.data)
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailState(
                        error = result.message ?: "Un error inesperado ocurrió"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
