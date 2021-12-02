package ru.geekbrains.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.geekbrains.mvp.databinding.ActivityMainBinding
import ru.geekbrains.mvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainView {
    private var vb: ActivityMainBinding? = null
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        val listener = View.OnClickListener {
            presenter.counterClick(it.id)
        }

        vb?.btnCounter1?.setOnClickListener(listener)
        vb?.btnCounter2?.setOnClickListener(listener)
        vb?.btnCounter3?.setOnClickListener(listener)
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

