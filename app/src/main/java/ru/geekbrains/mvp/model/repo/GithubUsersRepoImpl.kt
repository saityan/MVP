package ru.geekbrains.mvp.model.repo

import ru.geekbrains.mvp.model.GithubUser

class GithubUsersRepoImpl : GithubUsersRepo {
    private val users = listOf (
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

    override fun getUsers() : List<GithubUser> {
        return users
    }

    override fun getUserByLogin(userLogin: String): GithubUser? =
        users.firstOrNull{user -> user.login == userLogin}
}
