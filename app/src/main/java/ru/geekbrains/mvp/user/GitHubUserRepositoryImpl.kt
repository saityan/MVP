package ru.geekbrains.mvp.user

import io.reactivex.rxjava3.core.Observable

class GitHubUserRepositoryImpl : GitHubUserRepository {
    private val users = listOf(
        GitHubUser("Lion El'Jonson", "I"),
        GitHubUser("Jaghatai Khan", "V"),
        GitHubUser("Leman Russ", "VI"),
        GitHubUser("Rogal Dorn", "VII"),
        GitHubUser("Sanguinius", "IX"),
        GitHubUser("Ferrus Manus", "X"),
        GitHubUser("Roboute Guilliman", "XIII"),
        GitHubUser("Vulkan", "XVIII"),
        GitHubUser("Corvus Corax", "XIX")
    )

    override fun getUsers(): Observable<List<GitHubUser>> = Observable.just(users)

    override fun getUserByLogin(userLogin: String): Observable<GitHubUser> = Observable.just(users)
        .map { it.find { it.login == userLogin } }
}
