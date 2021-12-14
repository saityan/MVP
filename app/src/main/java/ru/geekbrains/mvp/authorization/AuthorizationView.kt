package ru.geekbrains.mvp.authorization

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.user.GitHubUser

interface AuthorizationView : MvpView {
    @SingleState
    fun sendData(login: String, password: String)

    @SingleState
    fun setErrorState(errorFlag : Boolean)
}