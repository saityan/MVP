package ru.geekbrains.mvp.presenter

import moxy.MvpPresenter
import ru.geekbrains.mvp.model.CountersModel
import ru.geekbrains.mvp.view.MainView

class MainPresenter (private val model: CountersModel) : MvpPresenter<MainView>() {
    fun counterClick(index: Int) {
        val nextValue = model.next(index)
        when (index) {
            0 -> viewState.setFirstButtonText(nextValue.toString())
            1 -> viewState.setSecondButtonText(nextValue.toString())
            2 -> viewState.setThirdButtonText(nextValue.toString())
        }
    }
}
