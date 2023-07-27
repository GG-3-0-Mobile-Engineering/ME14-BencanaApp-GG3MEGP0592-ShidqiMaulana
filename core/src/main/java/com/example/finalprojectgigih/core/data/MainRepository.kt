package com.example.finalprojectgigih.core.data

import com.example.finalprojectgigih.core.data.source.local.LocalDataSource
import com.example.finalprojectgigih.core.data.source.remote.RemoteDataSource
import com.example.finalprojectgigih.core.data.source.remote.network.ApiResponse
import com.example.finalprojectgigih.core.domain.model.AreaCode
import com.example.finalprojectgigih.core.domain.model.Report
import com.example.finalprojectgigih.core.domain.repository.IMainRepository
import com.example.finalprojectgigih.core.utility.AppExecutors
import com.example.finalprojectgigih.core.utility.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class MainRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMainRepository {
    override fun getReports(areaCode: String): Flow<Resource<List<Report>>> =
        flow {
            emit(Resource.Loading())
            when (val apiResponse = remoteDataSource.getReports(areaCode).first()) {
                is ApiResponse.Success -> {
                    val reportEntity = DataMapper.mapReportResponsesToEntities(apiResponse.data)
                    val report = DataMapper.mapReportEntitiesToDomain(reportEntity)
                    emit(Resource.Success(report))
                }

                is ApiResponse.Empty -> {
                    val report = ArrayList<Report>() as List<Report>
                    emit(Resource.Success(report))
                }

                is ApiResponse.Error -> {
                    emit(Resource.Error(apiResponse.errorMessage))
                }
            }
        }

    override fun insertAreaCode(areaCode: AreaCode) {
        val areaEntities = DataMapper.mapAreaDomainsToEntities(areaCode)
        appExecutors.diskIO().execute { localDataSource.insertAreaCode(areaEntities) }
    }

    override fun getAreaNameList(): List<String> {
        return localDataSource.getAreaName()
    }

    override fun getAreaCodeList(): List<AreaCode> {
        return DataMapper.mapAreaEntitiesToDomain(localDataSource.getAreaCode())
    }

}