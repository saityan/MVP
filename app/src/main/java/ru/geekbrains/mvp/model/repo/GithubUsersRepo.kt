package ru.geekbrains.mvp.model.repo

import ru.geekbrains.mvp.model.GithubUser

class GithubUsersRepo {
    private val repositories = listOf (
        GithubUser("Lion El'Jonson"),
        GithubUser("Jaghatai Khan "),
        GithubUser("Leman Russ"),
        GithubUser("Rogal Dorn"),
        GithubUser("Sanguinius"),
        GithubUser("Ferrus Manus"),
        GithubUser("Roboute Guilliman"),
        GithubUser("Vulkan"),
        GithubUser("Corvus Corax")
    )

    fun getUsers() : List<GithubUser> {
        return repositories
    }
}
