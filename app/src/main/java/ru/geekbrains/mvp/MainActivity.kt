package ru.geekbrains.mvp

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.mvp.App.Navigation.navigatorHolder
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.mvpusers.AuthorizationScreen
import ru.geekbrains.mvp.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(AuthorizationScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}