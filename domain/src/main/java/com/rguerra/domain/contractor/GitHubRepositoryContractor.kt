package com.rguerra.domain.contractor

import com.rguerra.domain.model.Repo
import io.reactivex.rxjava3.core.Single

interface GitHubRepositoryContractor {

    fun getPublicRepos(request: RepoSearchRequest): Single<List<Repo>>
}