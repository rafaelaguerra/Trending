package com.rguerra.trending.data.repository.di

import com.rguerra.trending.data.repository.GitHubRepository
import com.rguerra.trending.domain.GitHubRepositoryContractor
import org.koin.dsl.module

val repositoryModule = module {
    single<GitHubRepositoryContractor>(definition = { GitHubRepository(get()) })
}