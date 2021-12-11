package ru.geekbrains.mvp.mvpauthorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.AuthorizeUserBinding

class AuthorizationFragment: MvpAppCompatFragment(R.layout.authorize_user), AuthorizationView {

    private val presenter: AuthorizationPresenter by moxyPresenter {
        AuthorizationPresenter(router = router)
    }

    private lateinit var viewBinging: AuthorizeUserBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = AuthorizeUserBinding.bind(view)
    }

    companion object {
        fun newInstance(): Fragment = AuthorizationFragment()
    }
}