package ru.geekbrains.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import ru.geekbrains.mvp.databinding.FragmentUserBinding
import ru.geekbrains.mvp.presenter.BackButtonListener

class UserFragment : MvpAppCompatFragment(), BackButtonListener {
    companion object {
        fun newInstance() = UserFragment()
    }

    private var vb: FragmentUserBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUserBinding.inflate(inflater, container, false).also {
            vb = it
            it.userLogin.text = "1"
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = false
}