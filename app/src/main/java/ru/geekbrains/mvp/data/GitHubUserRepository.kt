package ru.geekbrains.mvp.data

import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>

    fun getUserRepositories(userId: String): Single<List<GitHubUserRepositories>>
}
