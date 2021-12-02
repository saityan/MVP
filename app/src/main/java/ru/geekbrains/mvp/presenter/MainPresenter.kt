package ru.geekbrains.mvp.presenter

import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.model.CountersModel
import ru.geekbrains.mvp.view.MainView

class MainPresenter (private val view: MainView) {
    private val model = CountersModel()

    fun counterClick(id: Int) {
        when(id) {
            R.id.btn_counter1 -> {
                val nextValue = model.next(0)
                view.setFirstButtonText(nextValue.toString())
            }
            R.id.btn_counter2 -> {
                val nextValue = model.next(1)
                view.setSecondButtonText(nextValue.toString())
            }
            R.id.btn_counter3 -> {
                val nextValue = model.next(2)
                view.setThirdButtonText(nextValue.toString())
            }
        }
    }
}
