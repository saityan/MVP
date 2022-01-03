package ru.geekbrains.mvp.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.data.GitHubUser

interface UserView : MvpView {

    @SingleState
    fun showPhoto(url: String)

    @SingleState
    fun showName(name: String)
}