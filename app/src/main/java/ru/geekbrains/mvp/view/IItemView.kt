package ru.geekbrains.mvp.view

interface ItemView {
    var pos: Int
}

interface UserItemView: ItemView {
    fun setLogin(text: String)
}
