package com.rguerra.data.repository

import com.rguerra.domain.contractor.GitHubRepositoryContractor
import com.rguerra.domain.contractor.RepoSearchRequest
import com.rguerra.domain.model.Repo
import com.rguerra.trending.data.network.api.GitHubApi
import io.reactivex.rxjava3.core.Single

class GitHubRepository(
    private val api: GitHubApi
) : GitHubRepositoryContractor {

    override fun getPublicRepos(request: RepoSearchRequest): Single<List<Repo>> =
        api.getPublicRepos(query = request.topic, request.page, request.numberPerPage)
            .map { items -> items.items.map { repoEntity -> repoEntity.toDomain() } }
}