package ru.geekbrains.mvp.mvpuser

import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository
import ru.geekbrains.mvp.navigation.CustomRouter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            ?.let(viewState::showUser)
    }
}