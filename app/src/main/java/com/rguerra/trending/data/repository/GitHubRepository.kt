package com.rguerra.trending.data.repository

import com.rguerra.trending.data.repository.model.RepoSearchRequest
import com.rguerra.trending.data.network.api.GitHubApi
import com.rguerra.trending.domain.GitHubRepositoryContractor
import com.rguerra.trending.presentation.Repo
import io.reactivex.rxjava3.core.Single

class GitHubRepository(
    private val api: GitHubApi
) : GitHubRepositoryContractor {

    override fun getPublicRepos(request: RepoSearchRequest): Single<List<Repo>> =
        api.getPublicRepos(query = request.topic, request.page, request.numberPerPage)
            .map { items -> items.items.map { repoEntity -> repoEntity.toDomain() } }
}