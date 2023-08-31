package com.example.tourismapp.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tourismapp.core.domain.usecase.TourismUseCase
import com.example.tourismapp.detail.DetailTourismViewModel
import com.example.tourismapp.di.AppScope
import com.example.tourismapp.favorite.FavoriteViewModel
import com.example.tourismapp.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val tourismUseCase: TourismUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(tourismUseCase) as T
            }
            modelClass.isAssignableFrom(DetailTourismViewModel::class.java) -> {
                DetailTourismViewModel(tourismUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}