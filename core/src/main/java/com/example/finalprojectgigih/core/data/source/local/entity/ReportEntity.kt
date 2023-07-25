package com.example.finalprojectgigih.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter

@Entity(tableName = "report")
data class ReportEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "pkey") var pkey: String,
    @ColumnInfo(name = "imageUrl") var imageUrl: String,
    @ColumnInfo(name = "disasterType") var disasterType: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "coordinates") var coordinates: List<Double?>?,
)