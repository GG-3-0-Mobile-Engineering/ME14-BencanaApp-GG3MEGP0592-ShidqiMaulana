package com.example.finalprojectgigih.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDAO {

    @Query("SELECT * FROM report")
    fun getReport(): Flow<List<ReportEntity>>

}