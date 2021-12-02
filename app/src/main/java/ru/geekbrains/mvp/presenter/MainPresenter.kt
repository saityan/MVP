package ru.geekbrains.mvp.presenter

import ru.geekbrains.mvp.model.CountersModel
import ru.geekbrains.mvp.view.MainView

class MainPresenter (private val view: MainView) {
    private val model = CountersModel()

    fun counterClick(index: Int) {
        val nextValue = model.next(index)
        when (index) {
            0 -> view.setFirstButtonText(nextValue.toString())
            1 -> view.setSecondButtonText(nextValue.toString())
            2 -> view.setThirdButtonText(nextValue.toString())
        }
    }
}
