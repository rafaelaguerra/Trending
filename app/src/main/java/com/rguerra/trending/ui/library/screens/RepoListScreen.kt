package com.rguerra.trending.ui.library.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rguerra.presentation.RepoListViewModel
import com.rguerra.trending.ui.library.components.RepoCard
import com.rguerra.trending.ui.library.components.RepoCardState

@Composable
internal fun RepoListScreen(viewModel: RepoListViewModel) {

    val state by viewModel.result.observeAsState()

    state?.fold(onData = { cards ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                count = cards.size,
                itemContent = { index -> RepoCard(RepoCardState(cards[index].name)) }
            )
        }
    }, onFailure = {
        // TODO
    })
}

@Preview
@Composable
internal fun RepoListScreenPreview() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            count = 1,
            itemContent = { RepoCard(RepoCardState("Demo title")) }
        )
    }
}
