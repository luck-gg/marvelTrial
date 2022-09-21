package com.example.marveltrial.presentation.characterlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.marveltrial.presentation.Screen
import com.example.marveltrial.presentation.characterlist.components.CharacterListItem

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val offset by viewModel.offset.collectAsState()
    val limit = viewModel.limit
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { viewModel.nextPage() }
        ) {
            Text(
                text = "Personajes de MARVEL",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Box(modifier = Modifier.fillMaxSize(0.90f)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.characters) { character ->
                    CharacterListItem(
                        character = character,
                        onItemClick = {
                            navController.navigate(Screen.CharacterDetailScreen.route + "/${character.id}")
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { viewModel.nextPage() }
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Image(imageVector = Icons.Default.ArrowForward, contentDescription = "Next")
                Text("$offset - ${offset + limit}")
            }
        }
    }
}
