package ru.geekbrains.mvp.user

import io.reactivex.rxjava3.core.Observable

interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUserByLogin(userLogin: String): Observable<GitHubUser>

}