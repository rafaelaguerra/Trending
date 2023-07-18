package com.rguerra.data.repository.model

import com.google.gson.annotations.SerializedName
import com.rguerra.domain.model.Owner
import com.rguerra.domain.model.Repo

data class RepoSearchEntity(
    @SerializedName("items")
    val items: List<RepoEntity>
)

data class RepoEntity(
    @SerializedName("id")
    val repoId: Long,
    @SerializedName("language")
    val repoLanguage: String?,
    @SerializedName("watchers")
    val repoWatchers: Double,
    @SerializedName("name")
    val repoName: String,
    @SerializedName("owner")
    val owner: OwnerEntity
) {

    fun toDomain() = Repo(
        id = repoId,
        name = repoName,
        technology = repoLanguage,
        watchers = repoWatchers,
        owner = owner.toDomain()
    )
}

data class OwnerEntity(
    @SerializedName("url")
    val url: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
) {
    fun toDomain() = Owner(
        avatarUrl = avatarUrl,
        name = login
    )
}