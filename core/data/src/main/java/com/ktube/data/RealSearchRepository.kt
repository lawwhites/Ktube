package com.ktube.data

import com.ktube.common.Result
import com.ktube.data.remote.YouTubeApi
import com.ktube.domain.SearchRepository
import com.ktube.model.SearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RealSearchRepository @Inject constructor(
    private val api: YouTubeApi
) : SearchRepository {
    override fun search(query: String): Flow<Result<List<SearchResult>>> = flow {
        emit(Result.Loading)
        try {
            if (query.isBlank()) {
                emit(Result.Success(emptyList()))
                return@flow
            }

            val response = api.searchVideos(
                part = "snippet",
                q = query,
                maxResults = 10
            )

            val items = response.items.map { item ->
                SearchResult(
                    id = item.id.videoId,
                    title = item.snippet.title,
                    thumbnailUrl = item.snippet.thumbnails.high.url.ifBlank {
                        item.snippet.thumbnails.medium.url.ifBlank {
                            item.snippet.thumbnails.default.url
                        }
                    },
                    channelTitle = item.snippet.channelTitle
                )
            }

            emit(Result.Success(items))
        } catch (t: Throwable) {
            emit(Result.Error(t))
        }
    }
}
