package com.example.marveltrial.presentation.characterlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.use_cases.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    init {
        getCharacters()
    }

    private fun getCharacters() {
        val charactersFlow = getCharactersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CharacterListState(error = result.message ?: "Un error inesperado ocurrió")
                }
            }
        }.launchIn(viewModelScope)
    }
}
