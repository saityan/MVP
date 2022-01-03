package ru.geekbrains.mvp

import android.app.Application
import ru.geekbrains.mvp.dagger.ApplicationComponent
import ru.geekbrains.mvp.dagger.DaggerApplicationComponent

class App: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .setContext(this)
            .build()

    }

    companion object{
        lateinit var instance: App
    }
}