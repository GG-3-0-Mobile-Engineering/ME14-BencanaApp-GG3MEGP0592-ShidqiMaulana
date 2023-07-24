package com.example.finalprojectgigih.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity

@Database(entities = [ReportEntity::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun mainDAO(): MainDAO
}