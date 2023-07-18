package com.rguerra.trending.domain

import com.rguerra.trending.data.repository.model.RepoSearchRequest
import com.rguerra.trending.presentation.Repo
import io.reactivex.rxjava3.core.Scheduler

private const val ANDROID_TOPIC = "android"

class GetAndroidPublicReposCase(
    private val repositoryContractor: GitHubRepositoryContractor,
    subscriberOn: Scheduler,
    observerOn: Scheduler
) : BaseSingleUseCase<List<Repo>, GetAndroidPublicReposCase.Param>
    (
    subscriberOn,
    observerOn,
    useCase = { repositoryContractor.getPublicRepos(RepoSearchRequest(ANDROID_TOPIC, it.page)) }
) {

    class Param(val page: Int = 1) : BaseUseCase.Params
}