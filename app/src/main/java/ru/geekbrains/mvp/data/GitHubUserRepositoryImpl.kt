package ru.geekbrains.mvp.data


class GitHubUserRepositoryImpl : GitHubUserRepository {
    private val users = listOf (
        GitHubUser("Lion El'Jonson"),
        GitHubUser("Jaghatai Khan "),
        GitHubUser("Leman Russ"),
        GitHubUser("Rogal Dorn"),
        GitHubUser("Sanguinius"),
        GitHubUser("Ferrus Manus"),
        GitHubUser("Roboute Guilliman"),
        GitHubUser("Vulkan"),
        GitHubUser("Corvus Corax")
    )

    override fun getUsers() = users

    override fun getUserByLogin(userId: String): GitHubUser? =
        users.firstOrNull{ user -> user.login == userId }
}
