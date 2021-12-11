package ru.geekbrains.mvp.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.view.UserFragment

class UserScreen(private val userLogin: String): FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstance(userLogin)

}