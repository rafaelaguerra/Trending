package com.rguerra.trending.ui.library

import androidx.compose.runtime.Composable
import com.rguerra.trending.ui.theme.H3BoldText
import com.rguerra.trending.ui.theme.Purple40

@Composable
internal fun TitleText(text: String) {
    H3BoldText(text = text, color = Purple40)
}
