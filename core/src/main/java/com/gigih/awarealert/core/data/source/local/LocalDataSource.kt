package com.gigih.awarealert.core.data.source.local

import com.gigih.awarealert.core.data.source.local.entity.AreaCodeEntity
import com.gigih.awarealert.core.data.source.local.entity.ReportEntity
import com.gigih.awarealert.core.data.source.local.room.MainDAO
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val mainDAO: MainDAO) {

    fun getReport(): Flow<List<ReportEntity>> = mainDAO.getReport()

    fun getAreaName(): List<String> = AreaData.name

    fun getAreaCode(): List<AreaCodeEntity> = AreaData.code

    fun insertAreaCode(areaCodeEntity: AreaCodeEntity) = mainDAO.insertAreaCode(areaCodeEntity)

}