package com.example.finalprojectgigih.core.domain.usecase

import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.domain.model.AreaCode
import com.example.finalprojectgigih.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    fun getReports(areaCode: String): Flow<Resource<List<Report>>>

//    fun getSearchedReports(areaCode: String): Flow<Resource<List<Report>>>

    fun getAreaNameList(): List<String>

    fun getAreaCodeList(): List<AreaCode>

}