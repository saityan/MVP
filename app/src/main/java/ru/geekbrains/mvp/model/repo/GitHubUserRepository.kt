package ru.geekbrains.mvp.model.repo

interface GitHubUserRepository {
    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userLogin: String): GitHubUser?
}