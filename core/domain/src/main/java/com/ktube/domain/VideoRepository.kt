package com.ktube.domain

import com.ktube.common.Result
import com.ktube.model.Video
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    fun getVideos(): Flow<Result<List<Video>>>
}
