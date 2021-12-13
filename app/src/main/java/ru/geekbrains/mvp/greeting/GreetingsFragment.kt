package ru.geekbrains.mvp.greeting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import ru.geekbrains.mvp.R
import ru.geekbrains.mvp.databinding.GreetUserBinding
import java.lang.Exception

class GreetingsFragment : MvpAppCompatFragment(R.layout.greet_user) {
    private lateinit var viewBinding: GreetUserBinding
    private var imageAlias : String? = null
    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = GreetUserBinding.bind(view)
        viewBinding.userGreeting.text = "Greetings, $userLogin!"
        imageAlias?.let {
            viewBinding.greetingImage.setImageResource(
                resources
                    .getIdentifier(imageAlias, "drawable", requireContext().packageName)
            )
        }
    }

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String, imageName: String?): Fragment =
            GreetingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_USER_LOGIN, userId)
                    imageAlias = imageName
                }
            }
    }
}