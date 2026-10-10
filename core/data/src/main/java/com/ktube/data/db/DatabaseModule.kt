package com.ktube.data.db

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): KtubeDatabase {
        return KtubeDatabase.getInstance(context)
    }

    @Provides
    fun provideHistoryDao(database: KtubeDatabase): HistoryDao {
        return database.historyDao()
    }

    @Provides
    fun provideFavoriteDao(database: KtubeDatabase): FavoriteDao {
        return database.favoriteDao()
    }
}
