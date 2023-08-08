package com.gigih.awarealert.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gigih.awarealert.core.data.source.local.entity.AreaCodeEntity
import com.gigih.awarealert.core.data.source.local.entity.ReportEntity
import com.gigih.awarealert.core.utility.ListConverter

@Database(
    entities = [ReportEntity::class, AreaCodeEntity::class], version = 1, exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class MainDatabase : RoomDatabase() {
    abstract fun mainDAO(): MainDAO

}