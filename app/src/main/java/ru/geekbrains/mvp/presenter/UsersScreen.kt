package ru.geekbrains.mvp.presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.view.UsersFragment

object UsersScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance()
}