package ru.geekbrains.mvp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.ViewUserBinding
import ru.geekbrains.mvp.model.repo.GitHubUser
import ru.geekbrains.mvp.model.repo.GitHubUserRepositoryFactory
import ru.geekbrains.mvp.presenter.UserPresenter

class UserFragment : MvpAppCompatFragment(R.layout.view_user), UserView {
    private lateinit var viewBinding: ViewUserBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = ViewUserBinding.bind(view)
    }

    override fun showUser(user: GitHubUser) {
        viewBinding.userLogin.text = user.login
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                }
            }
    }
}