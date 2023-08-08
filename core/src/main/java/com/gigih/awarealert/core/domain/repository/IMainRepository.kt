package com.gigih.awarealert.core.domain.repository

import com.gigih.awarealert.core.data.Resource
import com.gigih.awarealert.core.domain.model.AreaCode
import com.gigih.awarealert.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface IMainRepository {

    fun getReports(areaCode: String): Flow<Resource<List<Report>>>

    fun insertAreaCode(areaCode: AreaCode)

    fun getAreaNameList(): List<String>

    fun getAreaCodeList(): List<AreaCode>

}