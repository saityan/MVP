package ru.geekbrains.mvp.data

interface GitHubUserRepository {

    fun getUsers(): List<GitHubUser>

    fun getUserByLogin(userId: String): GitHubUser?

}