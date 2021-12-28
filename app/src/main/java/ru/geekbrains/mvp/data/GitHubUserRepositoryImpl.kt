package ru.geekbrains.mvp.data

import GitHubApiFactory
import android.util.Log
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.data.room.RoomFactory

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()
    private val roomDb = RoomFactory.create().getGitHubUserDao()

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return roomDb.getUserByLogin(userId)
    }
}
