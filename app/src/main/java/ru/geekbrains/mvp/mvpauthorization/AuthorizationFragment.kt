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

    private var login = ""
    private var password = ""

    private val presenter: AuthorizationPresenter by moxyPresenter {
        AuthorizationPresenter(router = router)
    }

    private lateinit var viewBinding: AuthorizeUserBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = AuthorizeUserBinding.bind(view)
        viewBinding.submitUserInfo.setOnClickListener {
            login = viewBinding.userLoginForm.text.toString()
            password = viewBinding.userPasswordForm.text.toString()
            sendData(login, password)
            viewBinding.userPasswordForm.setText("")
        }
    }

    companion object {
        fun newInstance(): Fragment = AuthorizationFragment()
    }

    override fun sendData(login: String, password: String) {
        if(presenter.checkData(login, password))
            viewBinding.userDataComplaint.visibility = View.VISIBLE
    }
}