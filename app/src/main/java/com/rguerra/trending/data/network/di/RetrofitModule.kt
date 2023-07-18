package com.rguerra.trending.data.network.di

import com.rguerra.trending.data.network.api.GitHubApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val GITHUB_SERVER_URL = "https://api.github.com"

val networkModule = module {
    single { OkHttpClient() }
    single { GsonConverterFactory.create() }
    single { RxJava3CallAdapterFactory.create() }
    single {
        createWebService(get(),
            get(),
            get(),
            GITHUB_SERVER_URL)
    }
}

val apiModule = module {
    single { createGitHubService(get()) }
}

private fun createGitHubService(retrofit: Retrofit) = retrofit.create(GitHubApi::class.java)

fun createWebService(okHttpClient: OkHttpClient,
                     converterFactory: GsonConverterFactory,
                     adapterFactory: RxJava3CallAdapterFactory,
                     url: String): Retrofit =
    Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addCallAdapterFactory(adapterFactory)
        .addConverterFactory(converterFactory)
        .build()