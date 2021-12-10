package ru.geekbrains.mvp.presenter

import com.github.terrakok.cicerone.Screen

interface Screens {
    fun users(): Screen
    fun user(userLogin: String): Screen
}