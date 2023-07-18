package com.rguerra.trending.domain

import com.rguerra.trending.data.repository.model.RepoSearchRequest
import com.rguerra.trending.presentation.Repo
import io.reactivex.rxjava3.core.Single

interface GitHubRepositoryContractor {

    fun getPublicRepos(request: RepoSearchRequest): Single<List<Repo>>
}