package com.dapoidev.catmov.core.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.core.source.local.entity.MovieEntity
import com.dicoding.core.source.local.room.MovieDao

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}