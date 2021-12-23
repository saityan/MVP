package ru.geekbrains.mvp.mvpuser

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        updateContent()
    }

    private fun updateContent() {
        userRepository.getUserByLogin(userLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showUser(it)
                },{
                    val errorMessage = it.message
                })
    }
}