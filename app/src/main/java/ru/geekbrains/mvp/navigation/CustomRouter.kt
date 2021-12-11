package ru.geekbrains.mvp.navigation

import com.github.terrakok.cicerone.Router

class CustomRouter : Router() {

    interface Command {
        fun execute(navigator: CustomNavigator)
    }
}