package ru.geekbrains.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.mvp.model.GithubUser
import ru.geekbrains.mvp.model.repo.GithubUsersRepo
import ru.geekbrains.mvp.view.MainView
import ru.geekbrains.mvp.view.UserItemView

class MainPresenter (private val usersRepo: GithubUsersRepo) : MvpPresenter<MainView>() {
    class UsersListPresenter : UserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {
            //TODO: переход на экран пользователя
        }
    }

    private fun loadData() {
        val users =  usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}
