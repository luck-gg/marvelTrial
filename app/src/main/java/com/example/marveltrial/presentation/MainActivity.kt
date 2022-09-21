package com.example.marveltrial.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marveltrial.presentation.characterdetail.CharacterDetailScreen
import com.example.marveltrial.presentation.characterlist.CharacterListScreen
import com.example.marveltrial.presentation.ui.theme.MarvelTrialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelTrialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController)
                        }
                        composable(
                            route = Screen.CharacterDetailScreen.route + "/{characterId}"
                        ) {
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
