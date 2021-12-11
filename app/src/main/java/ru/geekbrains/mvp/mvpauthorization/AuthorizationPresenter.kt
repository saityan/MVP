package ru.geekbrains.mvp.mvpauthorization

import moxy.MvpPresenter
import ru.geekbrains.mvp.navigation.CustomRouter

class AuthorizationPresenter(private val router: CustomRouter):
    MvpPresenter<AuthorizationView>() {

    override fun onFirstViewAttach() {
        displayAuthorization()
    }

    private fun displayAuthorization() = router.navigateTo(AuthorizationScreen)
}