package com.ktube.model

data class Video(
    val id: String,
    val title: String,
    val thumbnailUrl: String,
    val channelTitle: String,
    val durationSeconds: Long = 0L
)
