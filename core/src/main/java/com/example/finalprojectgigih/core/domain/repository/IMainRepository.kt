package com.example.finalprojectgigih.core.domain.repository

import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.domain.model.AreaCode
import com.example.finalprojectgigih.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface IMainRepository {

    fun getReports(areaCode: String): Flow<Resource<List<Report>>>

    fun insertAreaCode(areaCode: AreaCode)

    fun getAreaNameList(): List<String>

    fun getAreaCodeList(): List<AreaCode>

}