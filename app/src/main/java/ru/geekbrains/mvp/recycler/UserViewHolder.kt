package ru.geekbrains.mvp.recycler

import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.mvp.databinding.ViewUserBinding
import ru.geekbrains.mvp.data.GitHubUser

class UserViewHolder(private val viewBinding: ViewUserBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(user: GitHubUser, onUserClickListener: UsersAdapter.OnUserClickListener?) {
        viewBinding.userLogin.text = user.login
        viewBinding.root.setOnClickListener {
            onUserClickListener?.onUserPicked(user)
        }
    }
}