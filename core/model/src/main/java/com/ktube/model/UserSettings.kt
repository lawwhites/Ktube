package com.ktube.model

data class UserSettings(
    val autoplayEnabled: Boolean = true,
    val subtitlesEnabled: Boolean = false,
    val themeMode: String = "system"
)
