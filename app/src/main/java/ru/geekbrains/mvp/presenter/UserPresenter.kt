package ru.geekbrains.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.mvp.model.repo.GithubUsersRepo
import ru.geekbrains.mvp.view.UserView

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GithubUsersRepo,
    private val router: Router

) : MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)?.let {
                viewState :: showUser
            }
    }
}