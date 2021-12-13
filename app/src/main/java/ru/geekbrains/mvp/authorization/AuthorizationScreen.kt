package ru.geekbrains.mvp.authorization

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object AuthorizationScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        AuthorizationFragment.newInstance()

}