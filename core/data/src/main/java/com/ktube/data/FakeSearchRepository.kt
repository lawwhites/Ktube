package com.ktube.data

import com.ktube.common.Result
import com.ktube.domain.SearchRepository
import com.ktube.model.SearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeSearchRepository @Inject constructor() : SearchRepository {
    override fun search(query: String): Flow<Result<List<SearchResult>>> = flow {
        emit(Result.Loading)
        kotlinx.coroutines.delay(300)
        if (query.isBlank()) {
            emit(Result.Success(emptyList()))
            return@flow
        }

        emit(
            Result.Success(
                listOf(
                    SearchResult(
                        id = "1",
                        title = "Ktube Search Result: $query",
                        thumbnailUrl = "https://images.unsplash.com/photo-1492691527719-9d1e07e534b4",
                        channelTitle = "Demo Channel"
                    )
                )
            )
        )
    }
}
