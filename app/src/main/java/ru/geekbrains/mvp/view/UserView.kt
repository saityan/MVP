package ru.geekbrains.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.model.GithubUser


interface UserView : MvpView {
    @SingleState
    fun showUser(user: GithubUser)
}
