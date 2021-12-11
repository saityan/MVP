package ru.geekbrains.mvp.mvpusers

import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepository
import ru.geekbrains.mvp.mvpuser.UserScreen
import ru.geekbrains.mvp.navigation.CustomRouter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))
}