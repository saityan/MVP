package ru.geekbrains.mvp.view.navigation

import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward
import ru.geekbrains.mvp.presenter.UserScreen

class OpenDeepLink(private val deepLinkUserId: String) : CustomRouter.Command, Command {

    override fun execute(navigator: CustomNavigator) {
        navigator.applyCommand(Forward(UserScreen(deepLinkUserId)))
    }
}