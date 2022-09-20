package com.example.marveltrial.presentation.characterlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.marveltrial.domain.model.Character

@Composable
fun CharacterListItem(
    character: Character,
    onItemClick: (Character) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "${character.id}. ${character.name}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
//        Text(
//            text = if (character.isNew) "NEW!" else "",
//            style = MaterialTheme.typography.body2,
//            modifier = Modifier.align(Alignment.CenterVertically),
//            color = Color.Green
//        )
//        Text(
//            text = if (character.isActive) "active" else "inactive",
//            fontStyle = FontStyle.Italic,
//            style = MaterialTheme.typography.body2,
//            modifier = Modifier.align(Alignment.CenterVertically),
//            color = if (character.isActive) Color.Green else Color.Red
//        )
    }
}