package com.rguerra.trending.data.di

import com.rguerra.trending.data.network.di.apiModule
import com.rguerra.trending.data.network.di.networkModule
import com.rguerra.trending.data.repository.di.repositoryModule

val dataModule = listOf(
    networkModule,
    apiModule,
    repositoryModule
)