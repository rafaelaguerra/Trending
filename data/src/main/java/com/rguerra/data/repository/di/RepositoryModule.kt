package com.rguerra.data.repository.di

import com.rguerra.data.repository.GitHubRepository
import com.rguerra.domain.contractor.GitHubRepositoryContractor
import org.koin.dsl.module

val repositoryModule = module {
    single<GitHubRepositoryContractor>(definition = { GitHubRepository(get()) })
}