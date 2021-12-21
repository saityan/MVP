package ru.geekbrains.mvp.square

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class SquarePresenter() : MvpPresenter<SquareView>() {

    private val subject = BehaviorSubject.createDefault("")

    fun squareData(number: String) {
        var square: Int
        subject.onNext(number)
        subject
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    if (number != "" && number.toIntOrNull() != null &&
                        kotlin.math.abs(number.toInt()) < 46341)
                    {
                        square = number.toInt() * number.toInt()
                        viewState.setNumber(square)
                        viewState.setErrorState(false)
                    } else viewState.setErrorState(true)
                },
                { throwable -> viewState.setErrorState(true) }
            )
    }
}