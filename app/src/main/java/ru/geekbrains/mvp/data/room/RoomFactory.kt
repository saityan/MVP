package ru.geekbrains.mvp.data.room

import androidx.room.Room
import ru.geekbrains.mvp.App


object RoomFactory {

    private val database: DBStorage by lazy {
        Room.databaseBuilder(App.ContextHolder.context, DBStorage::class.java, "github.db")
            .build()
    }

    fun create(): DBStorage = database
}