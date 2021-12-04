package ru.geekbrains.mvp.view

import android.os.Bundle
import android.view.View
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.mvp.databinding.ActivityMainBinding
import ru.geekbrains.mvp.model.CountersModel
import ru.geekbrains.mvp.presenter.MainPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null
    private val presenter by moxyPresenter {
        MainPresenter(CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listenerFirst = View.OnClickListener {
            presenter.counterClick(0)
        }
        val listenerSecond = View.OnClickListener {
            presenter.counterClick(1)
        }
        val listenerThird = View.OnClickListener {
            presenter.counterClick(2)
        }

        vb?.btnCounter1?.setOnClickListener(listenerFirst)
        vb?.btnCounter2?.setOnClickListener(listenerSecond)
        vb?.btnCounter3?.setOnClickListener(listenerThird)
    }

    override fun setFirstButtonText(text: String) {
        vb?.btnCounter1?.text = text
    }
    override fun setSecondButtonText(text: String) {
        vb?.btnCounter2?.text = text
    }
    override fun setThirdButtonText(text: String) {
        vb?.btnCounter3?.text = text
    }
}
