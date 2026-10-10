package com.ktube.model

data class FavoriteItem(
    val id: String,
    val videoId: String,
    val title: String,
    val addedAtMillis: Long
)
