package com.example.tourismapp.core.di

import android.content.Context
import com.example.tourismapp.core.data.TourismRepository
import com.example.tourismapp.core.data.source.local.LocalDataSource
import com.example.tourismapp.core.data.source.local.room.TourismDatabase
import com.example.tourismapp.core.data.source.remote.RemoteDataSource
import com.example.tourismapp.core.data.source.remote.network.ApiConfig
import com.example.tourismapp.core.domain.repository.ITourismRepository
import com.example.tourismapp.core.domain.usecase.TourismInteractor
import com.example.tourismapp.core.domain.usecase.TourismUseCase
import com.example.tourismapp.core.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}