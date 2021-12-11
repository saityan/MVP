package ru.geekbrains.mvp.mvpusers

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.data.GitHubUser

interface UsersView : MvpView {
    @SingleState
    fun showUsers(users: List<GitHubUser>)
}