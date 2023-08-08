package com.gigih.awarealert.core.domain.usecase

import com.gigih.awarealert.core.data.Resource
import com.gigih.awarealert.core.domain.model.AreaCode
import com.gigih.awarealert.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    fun getReports(areaCode: String): Flow<Resource<List<Report>>>

    fun getAreaNameList(): List<String>

    fun getAreaCodeList(): List<AreaCode>

}