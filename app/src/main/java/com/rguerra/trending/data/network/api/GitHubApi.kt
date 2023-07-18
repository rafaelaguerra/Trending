package com.rguerra.trending.data.network.api

import com.rguerra.trending.data.repository.model.RepoSearchEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("search/repositories?sort=stars&order=desc")
    fun getPublicRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Single<RepoSearchEntity>
}