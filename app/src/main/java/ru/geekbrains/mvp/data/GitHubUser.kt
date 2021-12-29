package ru.geekbrains.mvp.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "GitHubUserTable")
data class GitHubUser(

    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: String,

    @ColumnInfo
    @SerializedName("login")
    val login: String? = null,

    @ColumnInfo
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @ColumnInfo
    @SerializedName("node_id")
    val node_id: String? = null,
) : Parcelable
