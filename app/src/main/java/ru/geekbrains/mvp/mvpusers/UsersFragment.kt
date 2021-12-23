package ru.geekbrains.mvp.mvpusers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.App.Navigation.router
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepositoryFactory
import ru.geekbrains.mvp.databinding.ViewUsersBinding
import ru.geekbrains.mvp.recycler.UsersAdapter

class UsersFragment: MvpAppCompatFragment(R.layout.view_users), UsersView, UsersAdapter.OnUserClickListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = ViewUsersBinding.bind(view)
        viewBinging.usersRecycler.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) {
        presenter.goToNextScreen(user.login!!)
    }

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }
}