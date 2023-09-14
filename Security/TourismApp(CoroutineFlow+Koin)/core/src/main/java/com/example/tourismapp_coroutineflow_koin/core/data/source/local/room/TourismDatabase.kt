package com.example.tourismapp_coroutineflow_koin.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tourismapp_coroutineflow_koin.core.data.source.local.entity.TourismEntity

@Database(entities = [TourismEntity::class], version = 1, exportSchema = false)
abstract class TourismDatabase : RoomDatabase() {

    abstract fun tourismDao(): TourismDao
}