package ru.geekbrains.mvp.mvpusers

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository
import ru.geekbrains.mvp.mvpuser.UserScreen
import ru.geekbrains.mvp.navigation.CustomRouter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
       updateContent()
    }

    fun goToNextScreen(login: String) {
        router.navigateTo(UserScreen(login))
    }

    fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            },{
                val errorMessage = it.message
                //DisplayError
            })
    }
}