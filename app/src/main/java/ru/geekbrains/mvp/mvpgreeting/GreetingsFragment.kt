package ru.geekbrains.mvp.mvpgreeting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.GreetUserBinding

class GreetingsFragment : MvpAppCompatFragment(R.layout.greet_user) {
    private lateinit var viewBinding: GreetUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = GreetUserBinding.bind(view)
        viewBinding.userGreeting.text = "Greetings"
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            GreetingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}