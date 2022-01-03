package ru.geekbrains.mvp.mvpuser

import android.widget.ImageView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.mvp.data.GitHubUserRepository
import javax.inject.Inject

class UserPresenter : MvpPresenter<UserView>() {

    @Inject
    lateinit var glideWrapper: GlideWrapper

    @Inject
    lateinit var repository: GitHubUserRepository

    private lateinit var userLogin: String

    fun init(userLogin: String) {
        this.userLogin = userLogin
    }

    override fun onFirstViewAttach() {
        repository.getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showName(it.login!!)
                viewState.showPhoto(it.avatarUrl!!)
            },{

            })
    }

    fun loadPhoto(url: String, imageView: ImageView){
        glideWrapper.loadImage(url, imageView)
    }
}