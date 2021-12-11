package ru.geekbrains.mvp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import ru.geekbrains.mvp.view.navigation.CustomRouter

class App: Application() {

    companion object Navigation {

        private val cicerone: Cicerone<CustomRouter> by lazy {
            Cicerone.create(CustomRouter())
        }
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router
    }
}