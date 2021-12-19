package ru.geekbrains.mvp.square

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.SquareFragmentBinding

class SquareFragment: MvpAppCompatFragment(R.layout.square_fragment), SquareView {

    private var number : String = ""

    private val presenter: SquarePresenter by moxyPresenter {
        SquarePresenter()
    }

    private lateinit var viewBinding: SquareFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = SquareFragmentBinding.bind(view)
        viewBinding.submitUserInfo.setOnClickListener {
            number = viewBinding.squareForm.text.toString()
            sendData(number)
        }
    }

    companion object {
        fun newInstance(): Fragment = SquareFragment()
    }

    override fun sendData(number: String) {
        presenter.squareData(number)
    }

    override fun setNumber(square : Int) {
        viewBinding.squareForm.setText(square.toString())
    }

    override fun setErrorState(errorFlag: Boolean) {
        if (errorFlag) viewBinding.userDataComplaint.visibility = View.VISIBLE
        else viewBinding.userDataComplaint.visibility = View.INVISIBLE
    }
}