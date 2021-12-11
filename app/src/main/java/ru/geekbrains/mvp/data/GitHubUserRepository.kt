package ru.geekbrains.mvp.data

interface GitHubUserRepository {
    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userLogin: String): GitHubUser?
}