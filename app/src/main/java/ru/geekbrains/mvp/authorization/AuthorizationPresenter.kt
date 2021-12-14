package ru.geekbrains.mvp.authorization

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.greeting.GreetingsScreen
import ru.geekbrains.mvp.navigation.CustomRouter
import ru.geekbrains.mvp.user.GitHubUserRepository
import java.util.*

class AuthorizationPresenter(
    private val router: CustomRouter,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<AuthorizationView>() {

    fun checkData(login: String, password: String) {
        userRepository.getUsers()
            .flatMap { userRepository.getUserByLogin(login) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    if (result.password == password) {
                        router.navigateTo(GreetingsScreen(
                            login,
                            login.filter { it.isLetterOrDigit() }.lowercase(Locale.ENGLISH)))
                        viewState.setErrorState(false)
                    } else viewState.setErrorState(true)
                },
                { throwable -> viewState.setErrorState(true)},
            )
    }
}