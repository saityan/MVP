package ru.geekbrains.mvp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.mvp.data.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class], version = 1)
abstract class DBStorage: RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao

}