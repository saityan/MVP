package ru.geekbrains.mvp.mvpuser

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.App
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.UserFragmentViewBinding

class UserFragment: MvpAppCompatFragment(R.layout.user_fragment_view), UserView {

    private lateinit var viewBinding: UserFragmentViewBinding

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter().apply {
            init(userLogin)
            App.instance.component.provideUserComponent().build().inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = UserFragmentViewBinding.bind(view)
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

    override fun showPhoto(url: String) {
        presenter.loadPhoto(url, viewBinding.image)
    }

    override fun showName(name: String) {
        viewBinding.textView.text = name
    }
}
