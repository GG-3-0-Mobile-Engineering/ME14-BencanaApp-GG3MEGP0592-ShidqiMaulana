package com.example.finalprojectgigih.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report")
data class ReportEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id: String,
)