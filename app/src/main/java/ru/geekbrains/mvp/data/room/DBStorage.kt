package ru.geekbrains.mvp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepositories

@Database(exportSchema = false, entities = [GitHubUserRepositories::class, GitHubUser::class], version = 1)
abstract class DBStorage: RoomDatabase() {
    abstract fun getGitHubUserDao(): GitHubUserDao
}
