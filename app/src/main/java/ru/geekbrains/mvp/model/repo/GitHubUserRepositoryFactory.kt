package ru.geekbrains.mvp.model.repo

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()
}