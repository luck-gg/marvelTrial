package com.example.marveltrial.presentation

sealed class Screen(val route: String) {
    object CharacterListScreen : Screen("character_list_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")
}
