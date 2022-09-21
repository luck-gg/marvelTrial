package com.example.marveltrial.presentation.characterdetail

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun CharacterDetailScreen(
//    navController: NavController,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.character?.let { character ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(10.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = character.name,
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier.weight(2f)
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            AsyncImage(
                                model = character.thumbnail,
                                contentDescription = null
                            )
                        }
                        Log.d("test", character.thumbnail)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    // Description
                    Text(
                        text = character.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    // Tags
                    Text(
                        text = "Apariciones",
                        style = MaterialTheme.typography.h2
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Comics",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = character.comics.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Historias",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = character.stories.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Series",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = character.series.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(
                                text = "Eventos",
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.padding(10.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                            Text(
                                text = character.events.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(5.dp)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                }
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
}
