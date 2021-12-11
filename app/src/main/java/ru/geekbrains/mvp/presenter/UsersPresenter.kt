package ru.geekbrains.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.mvp.model.repo.GitHubUser
import ru.geekbrains.mvp.model.repo.GitHubUserRepository
import ru.geekbrains.mvp.view.UsersView
import ru.geekbrains.mvp.view.navigation.CustomRouter

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