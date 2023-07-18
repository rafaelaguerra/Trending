package com.rguerra.trending.presentation

data class Repo(
    val id: Long,
    val name: String,
    val watchers: Double,
    val technology: String?,
    val owner: Owner
)

data class Owner(
    val avatarUrl: String,
    val name: String
)