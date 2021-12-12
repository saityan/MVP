package ru.geekbrains.mvp.mvpauthorization

import moxy.MvpPresenter
import ru.geekbrains.mvp.mvpgreeting.GreetingsScreen
import ru.geekbrains.mvp.navigation.CustomRouter

class AuthorizationPresenter(private val router: CustomRouter):
    MvpPresenter<AuthorizationView>() {

    fun checkData(login: String, password: String) : Boolean =
        if (checkLogin(login) && checkPassword(password)) {
            router.navigateTo(GreetingsScreen(login))
            false
        } else true

    private fun checkLogin(login: String) : Boolean = login.isNotBlank() && login.matches(
        "[a-zA-Z0-9]*"
            .toRegex())

    private fun checkPassword(password: String): Boolean = password.matches(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"
                .toRegex())

}