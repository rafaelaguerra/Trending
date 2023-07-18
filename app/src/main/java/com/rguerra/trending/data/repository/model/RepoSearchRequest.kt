package com.rguerra.trending.data.repository.model

private const val NUMBER_PER_PAGE = 10

data class RepoSearchRequest(
    val topic: String,
    val page: Int,
    val numberPerPage: Int = NUMBER_PER_PAGE
)