package ru.geekbrains.mvp.model.repo

import ru.geekbrains.mvp.model.GithubUser

class GithubUsersRepo {
    private val repositories = listOf (
        GithubUser("Lion El'Jonson"),
        GithubUser("Leman Russ"),
        GithubUser("Rogal Dorn"),
        GithubUser("Ferrus Manus"),
        GithubUser("Roboute Guilliman")
    )

    fun getUsers() : List<GithubUser> {
        return repositories
    }
}
