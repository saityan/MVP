package ru.geekbrains.mvp.data

import GitHubApiFactory
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepository

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()

    override fun getUsers(): Single<List<GitHubUser>> {
         return gitHubApi.fetchUsers()
    }

    override fun getUserByLogin(userId: String): GitHubUser? {
        return null
    }
}