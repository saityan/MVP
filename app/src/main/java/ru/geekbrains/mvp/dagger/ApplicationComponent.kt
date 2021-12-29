package ru.geekbrains.mvp.dagger

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.geekbrains.mvp.MainActivity
import ru.geekbrains.mvp.mvpuser.UserPresenter
import ru.geekbrains.mvp.mvpusers.UsersPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        RoomModule::class
    ])

public abstract interface ApplicationComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: UsersPresenter)
    fun inject(activity: UserPresenter)
}