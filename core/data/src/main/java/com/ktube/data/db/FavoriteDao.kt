package com.ktube.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FavoriteEntity)

    @Query("SELECT * FROM favorites ORDER BY addedAtMillis DESC LIMIT 50")
    fun getFavorites(): Flow<List<FavoriteEntity>>
}
