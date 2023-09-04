package com.example.tourismapp_coroutineflow_koin.core.data.source.local

import com.example.tourismapp_coroutineflow_koin.core.data.source.local.entity.TourismEntity
import com.example.tourismapp_coroutineflow_koin.core.data.source.local.room.TourismDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tourismDao: TourismDao) {
    fun getAllTourism(): Flow<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }
}