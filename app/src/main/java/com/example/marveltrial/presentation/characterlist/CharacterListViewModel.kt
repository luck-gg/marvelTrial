package com.example.marveltrial.presentation.characterlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltrial.common.Constants
import com.example.marveltrial.common.Resource
import com.example.marveltrial.domain.use_cases.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListState())
    val state: State<CharacterListState> = _state

    private val startOffset = 0
    private val _offset = MutableStateFlow(startOffset)
    val offset: StateFlow<Int> = _offset
    val limit: Int = Constants.LIMIT

    init {
        getCharacters(_offset.value)
    }

    fun nextPage() {
        _offset.value += Constants.LIMIT
        getCharacters(offset = offset.value)
    }

    private fun getCharacters(offset: Int) {
        val charactersFlow = getCharactersUseCase(offset).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CharacterListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        CharacterListState(error = result.message ?: "Un error inesperado ocurrió")
                }
            }
        }.launchIn(viewModelScope)
    }
}
