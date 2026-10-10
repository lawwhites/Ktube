package com.ktube.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey val id: String,
    val videoId: String,
    val title: String,
    val watchedAtMillis: Long
)
