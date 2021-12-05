package ru.geekbrains.mvp.presenter

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.view.UsersFragment

class AndroidScreens : Screens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance()
    }
}