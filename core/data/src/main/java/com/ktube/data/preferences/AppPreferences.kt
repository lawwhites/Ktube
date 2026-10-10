package com.ktube.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.ktube.model.UserSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "ktube_prefs")

class AppPreferences(private val context: Context) {
    companion object {
        private val AUTOPLAY = booleanPreferencesKey("autoplay_enabled")
        private val SUBTITLES = booleanPreferencesKey("subtitles_enabled")
        private val THEME_MODE = stringPreferencesKey("theme_mode")
    }

    val settingsFlow: Flow<UserSettings> = context.dataStore.data.map { prefs ->
        UserSettings(
            autoplayEnabled = prefs[AUTOPLAY] ?: true,
            subtitlesEnabled = prefs[SUBTITLES] ?: false,
            themeMode = prefs[THEME_MODE] ?: "system"
        )
    }

    suspend fun updateSettings(settings: UserSettings) {
        context.dataStore.edit { prefs ->
            prefs[AUTOPLAY] = settings.autoplayEnabled
            prefs[SUBTITLES] = settings.subtitlesEnabled
            prefs[THEME_MODE] = settings.themeMode
        }
    }
}
