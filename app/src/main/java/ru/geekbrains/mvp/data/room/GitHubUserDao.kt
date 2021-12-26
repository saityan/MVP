package ru.geekbrains.mvp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.data.GitHubUser

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM GitHubUserTable")
    fun getUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM GitHubUserTable WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun saveUser(users: List<GitHubUser>)

    @Insert(onConflict = REPLACE)
    fun saveUser(user: GitHubUser)
}
