package com.rguerra.trending.presentation.di

import com.rguerra.trending.presentation.RepoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { RepoListViewModel(get()) }
}