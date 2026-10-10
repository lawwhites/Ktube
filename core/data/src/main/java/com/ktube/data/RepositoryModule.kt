package com.ktube.data

import com.ktube.domain.SearchRepository
import com.ktube.domain.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindVideoRepository(repository: RealVideoRepository): VideoRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(repository: FakeSearchRepository): SearchRepository
}
