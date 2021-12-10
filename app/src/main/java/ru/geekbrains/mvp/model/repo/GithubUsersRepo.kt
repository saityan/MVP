package ru.geekbrains.mvp.model.repo

import ru.geekbrains.mvp.model.GithubUser

interface GithubUsersRepo {
    fun getUsers(): List<GithubUser>

    fun getUserByLogin(userLogin: String): GithubUser?
}