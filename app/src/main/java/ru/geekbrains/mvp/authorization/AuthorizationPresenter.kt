package ru.geekbrains.mvp.authorization

import android.util.Log
import android.view.View
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
    private val view: AuthorizationFragment?
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
                        Log.d("myLogs", login.filter { it.isLetterOrDigit() }.lowercase(Locale.ENGLISH))
                        view?.let { it.viewBinding.userDataComplaint.visibility = View.INVISIBLE }
                    } else {
                        setAuthorizationErrorVisible()
                    }
                },
                { throwable -> setAuthorizationErrorVisible() }
            )
    }

    private fun setAuthorizationErrorVisible() {
        view?.let { it.viewBinding.userDataComplaint.visibility = View.VISIBLE }
    }
}