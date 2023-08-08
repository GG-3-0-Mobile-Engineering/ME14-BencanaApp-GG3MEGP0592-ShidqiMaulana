package com.gigih.awarealert.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report")
data class ReportEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "pkey") var pkey: String,
    @ColumnInfo(name = "imageUrl") var imageUrl: String,
    @ColumnInfo(name = "disasterType") var disasterType: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "createdAt") var createdAt: String,
    @ColumnInfo(name = "source") var source: String,
    @ColumnInfo(name = "coordinates") var coordinates: List<Double?>?,
)