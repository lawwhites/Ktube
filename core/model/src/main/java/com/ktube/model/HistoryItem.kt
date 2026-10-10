package com.ktube.model

data class HistoryItem(
    val id: String,
    val videoId: String,
    val title: String,
    val watchedAtMillis: Long
)
