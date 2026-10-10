package com.ktube.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey val id: String,
    val videoId: String,
    val title: String,
    val addedAtMillis: Long
)
