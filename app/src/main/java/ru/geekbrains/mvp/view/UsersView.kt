package ru.geekbrains.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.model.repo.GitHubUser

interface UsersView : MvpView {
    @SingleState
    fun showUsers(users: List<GitHubUser>)
}