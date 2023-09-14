package com.example.tourismapp_coroutineflow_koin.core.domain.usecase

import com.example.tourismapp_coroutineflow_koin.core.data.Resource
import com.example.tourismapp_coroutineflow_koin.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {
    fun getAllTourism(): Flow<Resource<List<Tourism>>>
    fun getFavoriteTourism(): Flow<List<Tourism>>
    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}