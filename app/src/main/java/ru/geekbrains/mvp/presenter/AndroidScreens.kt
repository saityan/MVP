package ru.geekbrains.mvp.presenter

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.view.UserFragment
import ru.geekbrains.mvp.view.UsersFragment

class AndroidScreens : Screens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance()
    }
    override fun user(userLogin: String) = FragmentScreen {
        UserFragment.newInstance(userLogin)
    }
}