package com.ktube.data

import com.ktube.data.db.HistoryDao
import com.ktube.data.db.HistoryEntity
import com.ktube.model.HistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val historyDao: HistoryDao
) {
    fun getRecentHistory(): Flow<List<HistoryItem>> {
        return historyDao.getRecentHistory().map { list ->
            list.map { entity ->
                HistoryItem(
                    id = entity.id,
                    videoId = entity.videoId,
                    title = entity.title,
                    watchedAtMillis = entity.watchedAtMillis
                )
            }
        }
    }

    suspend fun addHistory(item: HistoryItem) {
        historyDao.insert(
            HistoryEntity(
                id = item.id,
                videoId = item.videoId,
                title = item.title,
                watchedAtMillis = item.watchedAtMillis
            )
        )
    }
}
