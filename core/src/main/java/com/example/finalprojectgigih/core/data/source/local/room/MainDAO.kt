package com.example.finalprojectgigih.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalprojectgigih.core.data.source.local.entity.AreaCodeEntity
import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDAO {

    @Query("SELECT * FROM report")
    fun getReport(): Flow<List<ReportEntity>>

    @Query("SELECT * FROM area")
    fun getAreaCode(): Flow<List<AreaCodeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAreaCode(areaCodeEntity: AreaCodeEntity)


}