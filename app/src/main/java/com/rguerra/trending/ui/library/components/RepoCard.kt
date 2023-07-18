package com.rguerra.trending.ui.library.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rguerra.trending.ui.library.TitleText

@Composable
fun RepoCard(card: RepoCardState) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = Modifier.padding(20.dp)) {
            Column(
                modifier = Modifier.weight(1f),
                Arrangement.Center
            ) {
                TitleText(text = card.title)
            }
            /**
            Image(painter = painterResource(emp.ImageId),
            contentDescription = "Profile Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
            .padding(8.dp)
            .size(110.dp)
            .clip((CircleShape)  ))
             **/
        }
    }
}

@Immutable
data class RepoCardState(
    val title: String
)
