package com.rguerra.domain.usecase

import com.rguerra.domain.contractor.GitHubRepositoryContractor
import com.rguerra.domain.contractor.RepoSearchRequest
import com.rguerra.domain.model.Repo
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

    class Param(val page: Int = 1) : Params
}