package com.rguerra.trending.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rguerra.trending.ui.library.screens.RepoListScreen
import com.rguerra.presentation.RepoListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListActivity : ComponentActivity() {

    private val viewModel: RepoListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RepoListScreen(viewModel) }
    }
}