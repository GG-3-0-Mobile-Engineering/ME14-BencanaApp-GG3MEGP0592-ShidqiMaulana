package com.example.finalprojectgigih.core.domain.repository

import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface IMainRepository {

    fun getReports(): Flow<Resource<List<Report>>>

}