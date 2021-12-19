package ru.geekbrains.mvp.square

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SquareScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        SquareFragment.newInstance()

}