package com.example.finalprojectgigih.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area")
data class AreaCodeEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "code") var code: String,
    @ColumnInfo(name = "name") var name: String,
)