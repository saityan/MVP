package ru.geekbrains.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.mvp.App.Navigation.navigatorHolder
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.presenter.UsersScreen
import ru.geekbrains.mvp.view.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}