package ru.geekbrains.mvp.mvpauthorization

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface AuthorizationView : MvpView {
    @SingleState
    fun sendData(login: String, password: String)
}