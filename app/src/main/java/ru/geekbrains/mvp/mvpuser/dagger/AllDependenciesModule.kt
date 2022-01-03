package ru.geekbrains.mvp.mvpuser.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.geekbrains.mvp.mvpuser.GlideWrapper


@Module
class AllDependenciesModule {

    @FragmentScope
    @Provides
    fun provideGlideWrapper(context: Context): GlideWrapper {
        return GlideWrapper(context)
    }

}