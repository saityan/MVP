package ru.geekbrains.mvp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.data.GitHubUser
import ru.geekbrains.mvp.data.GitHubUserRepositories

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<GitHubUser>)

    @Query("SELECT * FROM GitHubUserRepositoryTable WHERE login LIKE :login LIMIT 1")
    fun getUserRepositories(login: String): Single<List<GitHubUserRepositories>>

    @Insert(onConflict = REPLACE)
    fun saveUserRepositories(repositories: List<GitHubUserRepositories>)
}

