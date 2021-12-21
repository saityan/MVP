package ru.geekbrains.mvp

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.geekbrains.mvp.App.Navigation.navigatorHolder
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.square.SquareScreen
import ru.geekbrains.mvp.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        router.navigateTo(SquareScreen)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}