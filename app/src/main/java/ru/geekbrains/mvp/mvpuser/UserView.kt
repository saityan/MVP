package ru.geekbrains.mvp.mvpuser

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepositories

interface UserView : MvpView {

    @SingleState
    fun showRepositories(repositories: List<GitHubUserRepositories>)
}
