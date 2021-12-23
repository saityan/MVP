package ru.geekbrains.mvp.mvpusers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.mvp.mvpusers.UsersFragment

object UsersScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UsersFragment.newInstance()

}