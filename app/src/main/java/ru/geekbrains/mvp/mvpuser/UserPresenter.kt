package ru.geekbrains.mvp.mvpuser

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository

class UserPresenter(
    private val userLogin: String,
) : MvpPresenter<UserView>() {}
