package com.ktube.data

import com.ktube.common.Result
import com.ktube.data.remote.YouTubeApi
import com.ktube.domain.VideoRepository
import com.ktube.model.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RealVideoRepository @Inject constructor(
    private val api: YouTubeApi
) : VideoRepository {
    override fun getVideos(): Flow<Result<List<Video>>> = flow {
        emit(Result.Loading)
        try {
            val response = api.searchVideos(
                part = "snippet",
                q = "android tv app",
                maxResults = 10
            )

            val videos = response.items.map {
                Video(
                    id = it.id.videoId,
                    title = it.snippet.title,
                    thumbnailUrl = it.snippet.thumbnails.high.url.ifBlank {
                        it.snippet.thumbnails.medium.url
                    },
                    channelTitle = it.snippet.channelTitle,
                    durationSeconds = 240L
                )
            }

            emit(Result.Success(videos))
        } catch (t: Throwable) {
            emit(Result.Error(t))
        }
    }
}
