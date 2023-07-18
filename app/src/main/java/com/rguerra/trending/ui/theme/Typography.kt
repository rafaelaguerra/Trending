package com.rguerra.trending.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import h3Bold

@Composable
fun H3BoldText(text: String, modifier: Modifier = Modifier, color: Color, textAlign: TextAlign = TextAlign.Start, maxLines: Int = Int.MAX_VALUE) {
    Text(text, modifier = modifier, style = h3Bold, color = color, textAlign = textAlign, maxLines = maxLines)
}