package ru.geekbrains.mvp.dagger

import dagger.Module
import dagger.Provides
import ru.geekbrains.mvp.data.GitHubUserRepository
import ru.geekbrains.mvp.data.GitHubUserRepositoryImpl
import ru.geekbrains.mvp.data.retrofit.GitHubApi
import ru.geekbrains.mvp.data.room.DBStorage
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(@Named("prod") api: GitHubApi, dbStorage: DBStorage): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, dbStorage)
    }
}
