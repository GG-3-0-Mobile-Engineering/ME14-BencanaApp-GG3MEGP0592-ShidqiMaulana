package com.example.finalprojectgigih.core.data.source.local

import com.example.finalprojectgigih.core.data.source.local.entity.AreaCodeEntity
import com.example.finalprojectgigih.core.data.source.local.entity.ReportEntity
import com.example.finalprojectgigih.core.data.source.local.room.MainDAO
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mainDAO: MainDAO) {

    fun getReport(): Flow<List<ReportEntity>> = mainDAO.getReport()

    fun getAreaName(): List<String> = AreaData.name

    fun getAreaCode(): List<AreaCodeEntity> = AreaData.code

    fun insertAreaCode(areaCodeEntity: AreaCodeEntity) = mainDAO.insertAreaCode(areaCodeEntity)

}