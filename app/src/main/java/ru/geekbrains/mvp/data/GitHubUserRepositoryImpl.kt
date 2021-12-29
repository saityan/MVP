package ru.geekbrains.mvp.data

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.mvp.data.retrofit.GitHubApi
import ru.geekbrains.mvp.data.room.DBStorage
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val roomDb: DBStorage
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> {
        return roomDb.getGitHubUserDao().getUsers()
            .flatMap {
                if (it.isEmpty()) {
                    gitHubApi.fetchUsers()
                        .map { resultFromServer ->
                            roomDb.getGitHubUserDao().saveUser(resultFromServer)
                            resultFromServer
                        }
                } else {
                    Single.just(it)
                }
            }
    }

    override fun getUserByLogin(userId: String): Single<GitHubUser> {
        return roomDb.getGitHubUserDao().getUserByLogin(userId)
    }
}
