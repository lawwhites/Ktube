package com.ktube.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: HistoryEntity)

    @Query("SELECT * FROM history ORDER BY watchedAtMillis DESC LIMIT 50")
    fun getRecentHistory(): Flow<List<HistoryEntity>>
}
