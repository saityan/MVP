package ru.geekbrains.mvp.mvpusers

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository
import ru.geekbrains.mvp.mvpuser.UserScreen
import javax.inject.Inject

class UsersPresenter: MvpPresenter<UsersView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(login: String) {
        router.navigateTo(UserScreen(login))
    }

    private fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            },{
                val errorMessage = it.message
                errorMessage?.let { error ->
                    Log.e("UsersPresenter", error)
                }
            })
    }
}
