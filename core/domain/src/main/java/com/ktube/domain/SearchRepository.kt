package com.ktube.domain

import com.ktube.common.Result
import com.ktube.model.SearchResult
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun search(query: String): Flow<Result<List<SearchResult>>>
}
