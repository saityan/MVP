package ru.geekbrains.mvp.presenter

import ru.geekbrains.mvp.view.ItemView
import ru.geekbrains.mvp.view.UserItemView

interface ListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface UserListPresenter : ListPresenter<UserItemView>
