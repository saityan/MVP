package ru.geekbrains.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.mvp.model.repo.GitHubUserRepository
import ru.geekbrains.mvp.view.UserView
import ru.geekbrains.mvp.view.navigation.CustomRouter

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