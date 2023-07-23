package com.example.finalprojectgigih.core.domain.usecase

import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.domain.model.Report
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    fun getReports(): Flow<Resource<List<Report>>>

}