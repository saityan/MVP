package ru.geekbrains.mvp.square

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface SquareView : MvpView {
    @SingleState
    fun sendData(number: String)

    @SingleState
    fun setErrorState(errorFlag : Boolean)

    @SingleState
    fun setNumber(square: Int)
}