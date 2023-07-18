package com.rguerra.domain.contractor

data class RepoSearchRequest(
    val topic: String,
    val page: Int,
    val numberPerPage: Int = 10
)