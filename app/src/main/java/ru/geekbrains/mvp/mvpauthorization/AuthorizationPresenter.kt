package ru.geekbrains.mvp.mvpauthorization

import moxy.MvpPresenter
import ru.geekbrains.mvp.mvpgreeting.GreetingsScreen
import ru.geekbrains.mvp.navigation.CustomRouter

class AuthorizationPresenter(private val router: CustomRouter):
    MvpPresenter<AuthorizationView>() {

    fun checkData(login: String, password: String) {
        router.navigateTo(GreetingsScreen("T"))
    }
}