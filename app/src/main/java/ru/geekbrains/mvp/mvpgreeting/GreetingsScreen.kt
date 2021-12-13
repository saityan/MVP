package ru.geekbrains.mvp.mvpgreeting

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class GreetingsScreen(private val userLogin: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        GreetingsFragment.newInstance(userLogin)
}